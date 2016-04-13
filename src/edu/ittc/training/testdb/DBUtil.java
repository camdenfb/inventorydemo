package edu.ittc.training.testdb;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;

public class DBUtil {
	private static final String DATASOURCE_CONTEXT = "java:comp/env/jdbc/inven";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup(DATASOURCE_CONTEXT);
			if(ds != null){
				conn = ds.getConnection();
			}
		} catch(NamingException  | SQLException ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		} catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}