package com.cun.netDB;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAddress {
	public static void main(String args[]) {
		try { // ���´���ͨ����������InetAddress����
			InetAddress addr = InetAddress.getByName("www.weixueyuan.net");
			String domainName = addr.getHostName();// ���������
			String IPName = addr.getHostAddress();// ���IP��ַ
			System.out.println(domainName);
			System.out.println(IPName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}