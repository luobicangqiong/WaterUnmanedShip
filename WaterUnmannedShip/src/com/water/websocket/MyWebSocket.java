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

import sun.nio.cs.ext.SJIS;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.MAVLink.mavlinkpython.common.msg_gps_global_origin;
import com.water.dao.IGps_position;
import com.water.dao.IPositionDao;
import com.water.dao.ShipInforDao;
import com.water.dao.impl.Gps_positionDao;
import com.water.dao.impl.PositionDao;
import com.water.dao.impl.ShipInforImpl;
import com.water.entity.Position;

@ServerEndpoint("/mywebsocket")
public class MyWebSocket {
  //静态变量用来记录当前的连接数
  private static int onlineCount = 0;
  
  //   
  private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
   
  private Session session;
  
  SendMessage sendMessage;
   
  /**
   * 连接建立成功调用的方法
   * @param session  
   */
  @OnOpen
  public void onOpen(Session session){
      this.session = session;           
      System.out.println("有新的连接加入，当前在线的人数为" );
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
      System.out.println("来自客户端的消息:" + message);
       
      sendMessage.setSession(session);
      
      new Thread(sendMessage).start();

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


class SendMessage implements Runnable{

	private volatile Thread blinker; 
	private Session session;
	private IPositionDao positionDao = new PositionDao();
	private List<Position> positionList;
	IGps_position gpsdao = new Gps_positionDao();
	ShipInforDao shipdao = new ShipInforImpl();
	StringBuilder sb = new StringBuilder();
	
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
		int id = 1;
		blinker = Thread.currentThread();
		while(blinker != null)
		{
			
		 try {
			 ShipInformation ship = shipdao.getLastInfor();
			if(preId != ship.id)
			{
//			    id++;
//			    id = id%50;
				preId = ship.id;
				sb.delete(0, sb.length());
				sb.append(ship.watertemp + " ");
				sb.append(ship.shiptemp + " ");
				sb.append(ship.ph);
				session.getBasicRemote().sendText(sb.toString());
			}	
				Thread.sleep(1000*1);
			} catch (Exception e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}
	}
	
	
}
