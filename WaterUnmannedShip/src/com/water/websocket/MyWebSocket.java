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

import com.water.dao.IPositionDao;
import com.water.dao.impl.PositionDao;
import com.water.entity.Position;


//��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket������Servlet��ע��mapping��������web.xml�����á�
@ServerEndpoint("/mywebsocket")
public class MyWebSocket {
  //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
  private static int onlineCount = 0;
   
  //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
  private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
   
  //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
  private Session session;
  
  SendMessage sendMessage;
   
  /**
   * ���ӽ����ɹ����õķ���
   * @param session  ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
   */
  @OnOpen
  public void onOpen(Session session){
      this.session = session;           //��������1
      System.out.println("�������Ӽ��룡��ǰ��������Ϊ" );
      sendMessage = new SendMessage(session);
      new Thread(sendMessage).start();
  }
   
  /**
   * ���ӹرյ��õķ���
   */
  @OnClose
  public void onClose(){
  	  sendMessage.stop();
           //��������1    
      //System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
  }
   
  /**
   * �յ��ͻ�����Ϣ����õķ���
   * @param message �ͻ��˷��͹�������Ϣ
   * @param session ��ѡ�Ĳ���
   */
  @OnMessage
  public void onMessage(String message, Session session) {
      System.out.println("���Կͻ��˵���Ϣ:" + message);
       
      sendMessage.setSession(session);
      
      new Thread(sendMessage).start();
      
      //Ⱥ����Ϣ
//      for(MyWebSocket item: webSocketSet){             
//          try {
//              item.sendMessage(message);
//          } catch (IOException e) {
//              e.printStackTrace();
//              continue;
//          }
//      }
  }
   
  /**
   * ��������ʱ����
   * @param session
   * @param error
   */
  @OnError
  public void onError(Session session, Throwable error){
      System.out.println("��������");
      error.printStackTrace();
  }
   
  /**
   * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
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

		blinker = Thread.currentThread();
		while(blinker != null)
		{
			
			try {
				positionList = positionDao.getPosition(true);
				//System.out.println(positionList);
				if(!positionList.isEmpty())
				{
					for(Position position : positionList)
					{
						//System.out.println(position);
						float data = position.getPosition();
						sb.append(data); 
						sb.append(" ");
						positionDao.setPositionState(false, position.getId());
						
					}
					session.getBasicRemote().sendText(sb.toString());
					//System.out.println(sb.toString());
					sb.setLength(0);
				}
				
				Thread.sleep(1000*2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
