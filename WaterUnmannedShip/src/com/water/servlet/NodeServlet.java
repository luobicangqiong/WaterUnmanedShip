package com.water.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sun.beans.editors.FloatEditor;
import com.water.dao.IPositionDao;
import com.water.dao.impl.PositionDao;
import com.water.entity.Position;

public class NodeServlet extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void init() throws ServletException {
		
		System.out.println("NodeServlet服务启动开始");
		System.out.println("准备监听地面站发来的信息");
	
		try {
			
			ServerSocket serverSocket = new ServerSocket();
			//172.19.251.119
		   	serverSocket.bind(new InetSocketAddress("172.19.251.119",8086));
		   	System.out.println("socket配置完毕，准备监听了。。。。。");
			new SocketThread(serverSocket).start();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
//		StoreData st = new StoreData();
//		new Thread(st).start();
	}

}

class SocketThread extends Thread{
	
	ServerSocket serverSocket;
	
	public SocketThread(ServerSocket s) {
		// TODO Auto-generated constructor stub
		this.serverSocket = s;
	}
	@Override
	public void run() {
		while(true){
			try {
				
				Socket socket= serverSocket.accept();
				new Thread(new MyThread(socket)).start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}

class MyThread implements Runnable{
	
	IPositionDao positionDao = new PositionDao();
	Socket socket;
	public MyThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.socket  = s;
	}
	
	
	public void run() {
		
			try {
				InputStream inputStream = socket.getInputStream();
				//把输出流打印出来
				byte[] buf = new byte[1024];
				int length = 0;
				System.out.println("准备干活了。。。。");
				Position position = new Position();
				while((length = inputStream.read(buf))!=-1)
				{
					
					String dataTmp = new String(buf,0,length);
					dataTmp = dataTmp.trim();
					System.out.println("接收到的数据为："+ new String(buf,0,length));
					if(!"www.usr.cn".equals(dataTmp))
					{
//						float data = Float.parseFloat(dataTmp);
//						System.out.println(data);
//						position.setPosition(data);
//						position.setState(true);
//						positionDao.savePosition(position);
						
					}else{
						
						//System.out.println("接收到的数据为："+ new String(buf,0,length));
						
					}
					//OutputStream outputStream = socket.getOutputStream();
					//outputStream.write("Hello".getBytes());
				}
				System.out.println(length);
				System.out.println("接受完毕，准备关闭socket");
				socket.close() ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}

class StoreData implements Runnable{

	IPositionDao positionDao = new PositionDao();
	
	@Override
	public void run() {

		while(true){
			Position position = new Position();
			
			float random = (float)Math.random() * 100;
			position.setPosition(random);
			position.setState(true);
			positionDao.savePosition(position);
			//System.out.println("存取数据成功");
			try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
	
}

