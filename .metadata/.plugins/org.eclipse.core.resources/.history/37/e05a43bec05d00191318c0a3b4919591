package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;

public class ServerReceiverThread extends Thread{
	Socket s;
	HashMap hmSocket;
	
	public ServerReceiverThread(Socket s,HashMap hmSocket){
		this.s=s;
		this.hmSocket=hmSocket;
	}
	public void run(){
			ObjectInputStream ois;
		
			while(true){
				try {
				ois=new ObjectInputStream(s.getInputStream());
			Message mess=(Message)ois.readObject();
			System.out.println(mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent());
		
			if(mess.getMessageType().equals(Message.message_Common)){
				Socket s1=(Socket)hmSocket.get(mess.getReceiver());
			    ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
	            oos.writeObject(mess);//转达Massage
	            System.out.println("服务器转发了信息"+mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent());
			
			
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		
	}
}
