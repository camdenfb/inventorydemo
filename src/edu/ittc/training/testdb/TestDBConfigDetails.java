package edu.ittc.training.testdb;

import java.io.FileInputStream;
import java.util.Properties;

public class TestDBConfigDetails {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("dbConnection.conf"));
		
		System.out.println(prop.getProperty("DB_DRIVER_CLASS"));
		System.out.println(prop.getProperty("DB_URL"));
		System.out.println(prop.getProperty("DB_USERNAME"));
		System.out.println(prop.getProperty("DB_PASSWORD"));
	}
}
