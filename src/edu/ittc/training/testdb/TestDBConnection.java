package edu.ittc.training.testdb;

import java.sql.Connection;


public class TestDBConnection {
	public static void main(String[] args) {
		Connection conn;  // = db.getDBConnection();
		try {
			conn = DataSourceFactory.getDBConnection();
			System.out.println("Connection successfull...");
		} catch(Exception ex) {
			System.err.println("Connection not available...");
		}
	}
}
