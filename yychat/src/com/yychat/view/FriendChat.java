package com.yychat.view;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class FriendChat extends JFrame implements ActionListener{

	JScrollPane jsp;
	JTextArea jta;
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	
	
	public FriendChat(String sender,String receiver){
		
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
		if(arg0.getSource()==jb)
			jta.append(jtf.getText()+"\r\n");
		// TODO Auto-generated method stub
		
	}

}
