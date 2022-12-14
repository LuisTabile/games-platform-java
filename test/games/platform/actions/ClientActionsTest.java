/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package games.platform.actions;

import games.platform.models.Client;
import games.platform.models.Deposit;
import games.platform.models.Game;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luis.tabile
 */
public class ClientActionsTest {
    
    public ClientActionsTest() {
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

    @Test
    public void testBuyOneGame() {
        System.out.println("buyOneGame");
        Client client = null;
        Game game = null;
        Connection dbConnection = null;
        String expResult = "";
        String result = ClientActions.buyOneGame(client, game, dbConnection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddCash() {
        System.out.println("addCash");
        Deposit deposit = null;
        Connection dbConnection = null;
        String expResult = "";
        String result = ClientActions.addCash(deposit, dbConnection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
