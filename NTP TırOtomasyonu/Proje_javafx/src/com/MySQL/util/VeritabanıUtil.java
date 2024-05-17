package com.MySQL.util;
import java.sql.*;

public class VeritabanýUtil {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/týr_otomasyonu", "root", "");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
}
