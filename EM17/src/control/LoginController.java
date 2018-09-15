package control;

import DAO.AdminDAO;
import DAO.EventDAO;
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
    AdminDAO model;
    LoginPanel view;
    LoginController(){}
    public LoginController(AdminDAO x, LoginPanel y)
    {
        model = x;
        view = y;
        view.getLoginButton().addActionListener((ActionEvent e) -> {
            JTextField user = view.getUserField();
            JPasswordField password = view.getPassField();
            EventWindow prin = new EventWindow();
            EventDAO modello = new EventDAO();
            EventController control = new EventController(prin, modello);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            prin.setLocation(new Point((dimension.width - prin.getSize().width) / 2,
                    (dimension.height - prin.getSize().height) / 2 ));
            String p =  new String(password.getPassword());
            if (checkCredential(user.getText(), p) == 1){
                
                prin.setVisible(true);
                view.setVisible(false);
                
            }else
            {
                view.getErrorLabel().setVisible(true);
            }
        });
    }
    
    public int checkCredential(String user, String pass)
    {
        Admin admin = model.getAdmin(user);
        if(admin != null){
            if(user.equals(admin.getUsername()) && pass.equals(admin.getPassword()))
            {
                return 1;
            }
        }
        return -1;
    }
}
