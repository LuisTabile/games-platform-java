/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package games.platform.actions;

import games.platform.connection.DataBase;
import games.platform.models.Client;
import games.platform.models.Deposit;
import games.platform.models.Game;
import games.platform.utils.DbGlobal;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.util.Date;
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

    private static Connection connection;

    public ClientActionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbGlobal.generateDb();
        ClientActionsTest.connection = new DataBase().getConnection();
        LoggerGlobal.generateLogger();
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
        System.out.println("Teste 1 Comprar Jogos");
        Client client = new Client(3, "Luis", 74512f);
        Game game = new Game(1, "Dota", "MMORPG ", new Date(), 74f, 4, "Valve");
        Connection dbConnection = ClientActionsTest.connection;
        String expResult = "Compra Finalizada";
        String result = ClientActions.buyOneGame(client, game, dbConnection);
        assertEquals(expResult, result);
    }
     @Test
    public void testBuyOneGame2() {
        System.out.println("Teste 2 Comprar Jogos");
        Client client = new Client(7, "Pedro", 77452f);
        Game game = new Game(3, "", " ", new Date(), 34f, 7, "");
        Connection dbConnection = ClientActionsTest.connection;
        String expResult = "Compra Finalizada";
        String result = ClientActions.buyOneGame(client, game, dbConnection);
        assertEquals(expResult, result);
    }



    @Test
    public void testAddCash() {
        System.out.println("Teste 1 Adicionar Crédito");
        Deposit deposit = new Deposit (1,1000);
        Connection dbConnection = ClientActionsTest.connection;
        String expResult = "Crédito adicionado";
        String result = ClientActions.addCash(deposit, dbConnection);
        assertEquals(expResult, result);
    }

}
