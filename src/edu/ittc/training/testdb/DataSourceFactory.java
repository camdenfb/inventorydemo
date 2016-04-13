package edu.ittc.training.testdb;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {
	
	public static DataSource getDataSource() {
		MysqlDataSource ds = null;
		Properties props = new Properties();	
		try {
			props.load(new FileInputStream("dbConnection.conf"));
			ds = new MysqlDataSource();
	        ds.setURL(props.getProperty("DB_URL"));
	        ds.setUser(props.getProperty("DB_USERNAME"));
	        ds.setPassword(props.getProperty("DB_PASSWORD"));
	        
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return ds;
	}
	
	public static Connection getDBConnection() {
		Properties props = new Properties();	
		Connection conn = null;
		try {
			props.load(new FileInputStream("dbConnection.conf"));
			String url = props.getProperty("DB_URL");
			String user = props.getProperty("DB_USERNAME");
			String pass = props.getProperty("DB_PASSWORD");
					
			conn = DriverManager.getConnection(url, user, pass);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
}
