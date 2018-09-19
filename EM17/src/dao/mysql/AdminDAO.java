package dao.mysql;

import dao.interfaces.InterfaceAdminDAO;
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
    public Admin getAdmin(String username, String password) {
    Admin admin = new Admin();
    try {
            String query = "SELECT * FROM em17.admin";
            conn = db.Connect();
            stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("password").equals(password))
                {
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password")); 
                } else 
                {
                    return null;
                }
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
