/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import InterfaceDAO.InterfaceAdminDAO;
import database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

public class AdminDAO implements InterfaceAdminDAO{
    private Database db = new Database();
    private Connection conn = db.Connect();
    private Statement stm = null; 
    public Admin getAdmin() {
    Admin admin = new Admin();
    try {
            String query = "SELECT * FROM em17.admin WHERE username = 'admin'";
            conn = db.Connect();
            stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));  
            }
            rs.close();                
            conn.close();       
            
        }
        catch(SQLException e)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
   
    return admin;
    } 
}
