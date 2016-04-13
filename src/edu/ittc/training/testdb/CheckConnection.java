package edu.ittc.training.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckConnection {
	public static void main(String[] args) {
		try {
			//Class.forName(Connect.DRIVER);
			//Connection con = DriverManager.getConnection(Connect.CONNECTION_STRING, 
			//		Connect.USERNAME, Connect.PASSWORD);
			
			Connection conn = DataSourceFactory.getDBConnection();
			System.out.println("Connection very successfull");
			
			String query = "SELECT * FROM items";
			
			Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
			
            while(rs.next()) {
            	System.out.println(rs.getString("stockId")+": " + 
                     rs.getString("itemName"));
            	
            }
            
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
