/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.AdminDAO;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Admin;
import view.EventWindow;
import view.LoginPanel;
public class LoginController {
    AdminDAO model;
    LoginPanel view;
    public LoginController(AdminDAO x, LoginPanel y)
    {
        model = x;
        view = y;
        view.getLoginButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JTextField user = view.getUserField();                
                JPasswordField password = view.getPassField();
                Admin admin = model.getAdmin();
                EventWindow prin = new EventWindow();
                
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                prin.setLocation(new Point((dimension.width - prin.getSize().width) / 2, 
                (dimension.height - prin.getSize().height) / 2 ));
                String p =  new String(password.getPassword());
                if (user.getText().equals(admin.getUsername()) && p.equals(admin.getPassword())){
                    
                    prin.setVisible(true);
                    view.setVisible(false);
                    
                }
            }
            
        });
    }
}
