package com.yychat.view;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.yychat.controller.ClientConnetion;
import com.yychat.model.Message;

public class FriendChat extends JFrame implements ActionListener,Runnable{//只允许单继承，但是可以实现多接口

	JScrollPane jsp;
	JTextArea jta;
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	
	String sender;
	String receiver;
	public FriendChat(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		
		jta=new JTextArea();
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp.add(jtf);jp.add(jb);
		this.add(jp,"South");
		
		this.setSize(350,240);
		this.setTitle(sender+"正在和"+receiver+"聊天");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb){
			String content=jtf.getText();
			jta.append(jtf.getText()+"\r\n");
			
			//发送Message对象到服务器
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(receiver);
			mess.setContent(content);
			//mess.setMessageType("2");//common聊天的普通信息
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				oos=new ObjectOutputStream(ClientConnetion.s.getOutputStream());
			    oos.writeObject(mess);
			    
			    /*ObjectInputStream ois=new ObjectInputStream(ClientConnetion.s.getInputStream());
				mess=(Message)ois.readObject();
			    jta.append(mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent()+"\r\n");
	*/
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		// TODO Auto-generated method stub		
	}

	@Override
	public void run() { 
		ObjectInputStream ois;
		Message mess;
		try {
			ois = new ObjectInputStream(ClientConnetion.s.getInputStream());
			mess=(Message)ois.readObject();
	    jta.append(mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent()+"\r\n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
