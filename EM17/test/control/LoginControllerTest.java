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
    public void testCheckCredential1() {
        String user = "";
        String pass = "";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential2() {
        String user = "";
        String pass = "1234";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential3() {
        String user = "";
        String pass = "12345";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential4() {
        String user = "morenanza";
        String pass = "";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential5() {
        String user = "morenanza";
        String pass = "1234";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential6() {
        String user = "morenanza";
        String pass = "12345";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential7() {
        String user = "admin";
        String pass = "";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential8() {
        String user = "admin";
        String pass = "1234";
        LoginController instance = new LoginController(view);
        int expResult = 1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckCredential9() {
        String user = "admin";
        String pass = "12345";
        LoginController instance = new LoginController(view);
        int expResult = -1;
        int result = instance.checkCredential(user, pass);
        assertEquals(expResult, result);
    }
    
}
