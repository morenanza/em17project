/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.EventDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.EventWindow;

/**
 *
 * @author Morena
 */
public class EventControllerTest {
    EventController instance;
    EventWindow view;
    EventDAO dao;
    public EventControllerTest() {
        
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
     * Test of checkValidExtension method, of class EventController.
     */
    @Test
    public void testCheckValidExtension() {
        
        String namefile = "prova.pdf";
        EventController instance = new EventController();
        int expResult = -1;
        int result = instance.checkValidExtension(namefile);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckValidExtension2() {
        
        String namefile = "prova.jpg";
        EventController instance = new EventController();
        int expResult = 1;
        int result = instance.checkValidExtension(namefile);
        assertEquals(expResult, result);
    }
    
}
