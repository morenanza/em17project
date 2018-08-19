/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Morena
 */
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
