package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    private Connection conn = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://mysql-em17.c2r9w4cnwtew.us-east-1.rds.amazonaws.com";
    static final String USER = "admin";
   static final String PASS = "p1a2ssword";
   
   public Connection Connect() {		
        try {
               			
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(SQLException e) {
                System.out.println(e.getMessage());
        }
    return conn;	
    }
   
   
}
