package com.MySQL.util;
import java.sql.*;

public class Veritaban�Util {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/t�r_otomasyonu", "root", "");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
}
