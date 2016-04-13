package edu.ittc.training.testdb;

public class Connect {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE_NAME = "inventoryDB";
    public static final String USERNAME = "root";
    public static final String PASSWORD  = "";
    public static final String CONNECTION_STRING =
            "jdbc:mysql://"+Connect.HOSTNAME+":"+Connect.PORT+"/"+Connect.DATABASE_NAME;
    //public static final String CONNECTION_STRING =
    //"jdbc:oracle:thin:@"+Connect.PORT+"/"+Connect.DATABASE_NAME;
}
