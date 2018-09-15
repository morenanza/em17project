/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.AdminDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.LoginPanel;

/**
 *
 * @author Morena
 */
public class LoginControllerTest {
    AdminDAO model = new AdminDAO();
    LoginPanel view = new LoginPanel();
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkCredential method, of class LoginController.
     */
    @Test
    public void testCheckCredential() {
        System.out.println("checkCredential");
        String user = "admin";
        String pass = "1234";
        LoginController instance = new LoginController(model,view);
        int expResult = 1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    
}
