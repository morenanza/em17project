package control;

import dao.mysql.AdminDAO;
import dao.mysql.EventDAO;
import dao.interfaces.InterfaceAdminDAO;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Admin;
import view.EventWindow;
import view.LoginPanel;
public class LoginController {
    InterfaceAdminDAO model;
    LoginPanel view;
    LoginController(){}
    public LoginController(LoginPanel y)
    {
        model = new AdminDAO();
        view = y;
    }
    
    public void login(String user, String password)
    {
        
        
            EventWindow prin = new EventWindow();
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            prin.setLocation(new Point((dimension.width - prin.getSize().width) / 2,
                    (dimension.height - prin.getSize().height) / 2 ));
            
            if(checkCredential(user, password) == 1){
                    prin.setVisible(true);
                    view.setVisible(false);
                  

                }else
                {
                    view.getErrorLabel().setVisible(true);
                    
                }
           
    }
    
    public int checkCredential(String user, String password)
    {
        Admin admin = model.getAdmin(user, password);
        if(admin != null)
        {
            return 1;
        }
        return -1;
    }
}
