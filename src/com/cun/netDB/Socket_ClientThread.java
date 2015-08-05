package com.cun.netDB;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;

/*【例 13-5】 将套接字连接工作置于线程的客户端小应用程序。
 * 界面在有一个发送信息按纽、一个文本框和一个文本区。
 * 客户端应用程序首先与服务器建立套接字连接。
 * 使用数据输入流in反复读取服务器放入线路里的信息，将收到的信息在文本区中显示。
 * 如果取的信息是"结束"，则关闭套接字连接，并结束程序。
 * 用户也可在文本框输入信息，并按发送信息按钮，
 * 则客户端程序利用数据输出流out,将文本框中的内容发送给服务器。*/
@SuppressWarnings("serial")
public class Socket_ClientThread extends Applet implements Runnable,
		ActionListener {
	JButton button;
	JTextField textF;
	JTextArea textA;
	Socket socket;
	Thread thread;
	DataInputStream in;
	DataOutputStream out;

	public void init() {
		setBackground(new Color(120, 153, 137));
		setLayout(new BorderLayout());
		button = new JButton("发送信息");
		textF = new JTextField(20);
		textA = new JTextArea(20, 30);
		setSize(450, 350);
		JPanel p = new JPanel();
		p.add(textF);
		p.add(button);
		add(textA, "Center");
		add(p, "South");
		button.addActionListener(this);
	}

	public void start() {
		try {
			socket = new Socket(this.getCodeBase().getHost(), 4441);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
		}
		if (thread == null) {
			thread = new Thread(this);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		}
	}

	public void run() {
		String s = null;
		while (true) {
			try {
				s = in.readUTF();
			} catch (IOException e) {
			}
			if (s.equals("结束")) {
				try {
					socket.close();
					break;
				} catch (IOException e) {
				}
			} else {
				textA.append(s + "\n");
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			String s = textF.getText();
			if (s != null) {
				try {
					out.writeUTF(s);
				} catch (IOException e1) {
				}
			} else {
				try {
					out.writeUTF("请说话");
				} catch (IOException e1) {
				}
			}
		}
	}
}