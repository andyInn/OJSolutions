package com.cun.netDB;

import java.sql.Connection;
import java.sql.SQLException;
/*【例 13-8】说明与数据库连接的静态方法connectByJdbc()，
 * 该方法按给定的数据库URL、用户名和密码连接数据库，
 * 如果连接成功，方法返回true，连接不成功，则返回false。*/
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) {
		//
	}

	public static Connection conectByJdbc(String url, String username,	String password) {

		Connection con = null;
		try {
			Class.forName( // 加载特定的驱动程序
			"com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
			return null; // 连接失败
		}
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // 连接失败
		}
		return con; // 连接成功
	}
}