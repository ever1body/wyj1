package com.yychat.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.model.User;

public class ClientConnetion {
    Socket s;
	public ClientConnetion(){
		try {//异常处理结构
			s=new Socket("127.0.0.1",3456);//本机地址，回测地址
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
    public void loginValidate(User user){
    	ObjectOutputStream oos;
	 //对象的输入输出流
    	try {
			oos=new ObjectOutputStream(s.getOutputStream());//把字节输出流对象包装对象输出流对象
			oos.writeObject(user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	}