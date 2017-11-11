package com.cg.frs.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

public static Connection getConnection() throws IOException, SQLException{
		
		Connection con = null;
		Properties prop = readDbInfo();
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		con = DriverManager.getConnection(url, username, password);
		
		return con;
		
	}
	
	
	private static Properties readDbInfo() throws IOException{
		
		Properties p = new Properties();
		FileReader fr = new FileReader("RealEstateInfo.properties");
		p.load(fr);
		
		return p;
		
	}
}
