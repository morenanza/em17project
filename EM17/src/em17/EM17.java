/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em17;

import dao.mysql.AdminDAO;
import control.LoginController;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JFrame;
import view.LoginPanel;

public class EM17 {

   
    public static void main(String[] args) throws SQLException {
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        
        
        
        LoginPanel login = new LoginPanel();
        
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        login.setLocation(new Point((dimension.width - login.getSize().width) / 2, 
        (dimension.height - login.getSize().height) / 2 ));
        login.setVisible(true);
    }
    
}
