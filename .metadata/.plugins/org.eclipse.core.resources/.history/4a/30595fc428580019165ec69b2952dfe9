package com.yychat.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.yychat.model.Message;

public class ClientReceiverThread extends Thread{
  Socket s;
  
  public ClientReceiverThread(Socket s){
	  this.s=s;
  }
  public void run(){ 
	  ObjectInputStream ois;
 
	  Message mess;
	  while(true){
		  //接收服务器转发过来的Message
		  try {
			ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();//等待Server发送Message,阻塞
			System.out.println((mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent()));
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  }
		  
  }
	 
		

			  
		  
	  
 

