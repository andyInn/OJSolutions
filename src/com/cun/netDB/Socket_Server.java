package com.cun.netDB;

/*【例 13-4】与例10.3 Client端应用程序对应的Server端应用程序。
 * 程序在4441端口监听，当检测到有客户机请求时，
 * 产生一个内为"客户，你好，我是服务器"的字符串输出到客户端。*/
import java.io.*;
import java.net.*;

public class Socket_Server {
	public static void main(String args[]) {
		ServerSocket server = null;
		Socket you = null;
		String s = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			server = new ServerSocket(4441);
		} catch (IOException e1) {
			System.out.println("ERROR:" + e1);
		}
		try {
			you = server.accept();
			in = new DataInputStream(you.getInputStream());
			out = new DataOutputStream(you.getOutputStream());
			while (true) {
				s = in.readUTF();
				if (s != null)
					break;
			}
			out.writeUTF("客户，你好，我是服务器");
			out.close();
		} catch (IOException e) {
			System.out.println("ERROR:" + e);
		}
	}
}