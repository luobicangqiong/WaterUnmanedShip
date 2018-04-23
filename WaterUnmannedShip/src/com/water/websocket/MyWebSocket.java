package com.water.websocket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.alibaba.fastjson.JSONObject;
import com.water.dao.ShipInforDao;
import com.water.dao.impl.ShipInforImpl;
import com.water.utils.Server2WebProtocol;

@ServerEndpoint("/mywebsocket")
public class MyWebSocket {
  //静态变量用来记录当前的连接数
  private static int onlineCount = 0;
  
  //   
  private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
   
  ShipInforDao shipdao = new ShipInforImpl();
  private Session session;
  
  SendMessage sendMessage;
  /**
   * 连接建立成功调用的方法
   * @param session  
   */
  @OnOpen
  public void onOpen(Session session){
      this.session = session;           
      sendMessage = new SendMessage(session);
      new Thread(sendMessage).start();
  }
   
  /**
   * 连接关闭的方法
   */
  @OnClose
  public void onClose(){
  	  sendMessage.stop();
  }
   
  /**
   * 收到客户端消息后调用的方法
   * @param message 客户端发送来的消息
   * @param session 可选的参数
   */
  @OnMessage
  public void onMessage(String message, Session session) {
	  sendMessage.setReadTime(false);
      System.out.println("来自客户端的消息:" + message);
      List<ShipInformation> list = shipdao.getSpecialData("2018-03-23 10:00:00", "2018-04-03 10:00:00");
      sendMessage.setSession(session);
      List<JSONObject> jsonList = Server2WebProtocol.getJsonList(list);
      String jString = "";
      for(JSONObject jsonObject : jsonList)
      {
    	  
    	  jString += jsonObject.toJSONString();
      }
      try {
    	 System.out.println(jString);
		 session.getBasicRemote().sendText(jString);
		 sendMessage.setReadTime(true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //new Thread(sendMessage).start();

  }
   
  /**
   * 发生错误时调用
   * @param session
   * @param error
   */
  @OnError
  public void onError(Session session, Throwable error){
      System.out.println("出现错误");
      error.printStackTrace();
  }
   
  /**
   * 发送消息
   * @param message
   * @throws IOException
   */
  public void sendMessage(String message) throws IOException{
      this.session.getBasicRemote().sendText(message);
      //this.session.getAsyncRemote().sendText(message);
  }

  public static synchronized int getOnlineCount() {
      return onlineCount;
  }

  public static synchronized void addOnlineCount() {
      MyWebSocket.onlineCount++;
  }
   
  public static synchronized void subOnlineCount() {
      MyWebSocket.onlineCount--;
  }
}
/**
 * 发送消息的线程，现在要考虑的是消息多了以后如何不跟实时发送的消息混淆
 * @author luobicangqiong
 *
 */

class SendMessage implements Runnable{

	private volatile Thread blinker; 
	private Session session;
	ShipInforDao shipdao = new ShipInforImpl();
	private boolean readTime = true;
	
	
	public boolean isReadTime() {
		return readTime;
	}



	public void setReadTime(boolean readTime) {
		this.readTime = readTime;
	}



	public void setSession(Session session) {
		this.session = session;
	}

	
	
	public SendMessage(Session session) {
		super();
		this.session = session;
	}



	public void stop()
	{
		
		blinker = null;
	}
	
	@Override
	public void run() {
		
		int preId = 0;
		blinker = Thread.currentThread();
		String sendData = "";
		while(blinker != null)
		{
			
		 try {
			ShipInformation ship = shipdao.getLastInfor();
			if(preId != ship.id)
			{
				preId = ship.id;
				JSONObject json = Server2WebProtocol.getSingleJsonObject(ship);
				if(!this.readTime){
					
					sendData += json.toJSONString();
					
				}else{
					try {
						if(sendData != ""){
							
							session.getBasicRemote().sendText(sendData);
							sendData = "";
							
						}else{
							
							session.getBasicRemote().sendText(json.toJSONString());
						}
					} catch (Exception e) {
						e.printStackTrace(); 
					}
			    }
			}
				Thread.sleep(1000*1);
			} catch (Exception e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}
	}
	
	
}
