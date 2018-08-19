/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em17;

import DAO.AdminDAO;
import control.LoginController;
import database.Database;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import view.LoginPanel;

/**
 *
 * @author Morena
 */
public class EM17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        
        AdminDAO modello = new AdminDAO();
        
        LoginPanel login = new LoginPanel();
        LoginController controllo = new LoginController(modello, login);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        login.setLocation(new Point((dimension.width - login.getSize().width) / 2, 
        (dimension.height - login.getSize().height) / 2 ));
        login.setVisible(true);     
        /*Database db = new Database();
        Connection conn = db.Connect();
        Statement stmt = null;
        stmt = conn.createStatement();
      String sql;
      sql= "INSERT INTO em17.event (title, position, city, date, hour, ticketsTot, ticketsAvaible, type, description) VALUES ('Beyonce in tour', 'Foro Italico', 'Roma', '27-03-2019', '21:30', '3000', '0', 'Concerto', 'Descrizione')";
      stmt.executeUpdate(sql);*/
    }
    
}
