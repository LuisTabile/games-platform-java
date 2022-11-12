package games.platform.dbModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clients {

    /**
     * Get the query string to get all clients
     *
     * @return all clients
     */
    public static String getClients() {
        return "SELECT * FROM client";
    }
    
    /**
     * Get the query string to get all clients with all games
     *
     * @return all clients with all games
     */
    public static String getClientsWithGames() {
        return "SELECT c.id, c.name, b.game_id, g.name as game_name FROM client as c JOIN buy as b ON (c.id = b.client_id) JOIN game as g ON (g.id = b.game_id)";
    }
    
    /**
     * Get the query string to get client with all games
     *
     * @param clientId client id to get the games
     * @return client with all games
     */
    public static String getClientsWithGames(int clientId) {
        return getClientsWithGames().concat(" WHERE client.id = " + clientId);
    }
    
    /**
     * Get the PreparedStatement to decrease client balance
     *
     * @param clientId client id to decrease balance
     * @param gamePrice game price
     * @param dbConnection database Connection
     * @return PreparedStatement to decrease client balance
     */
    public static PreparedStatement getClientBalanceDecreaseStatement(int clientId, float gamePrice, Connection dbConnection) throws SQLException{
        PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE client SET balance = balance - ? WHERE id = ?");

        pstmt.setFloat(1, gamePrice);
        pstmt.setInt(2, clientId);
        
        return pstmt;
    }
    
    /**
     * Get the PreparedStatement to increase client balance
     *
     * @param clientId client id to increase balance
     * @param value value to be increased
     * @param dbConnection database Connection
     * @return PreparedStatement to decrease client balance
     */
    public static PreparedStatement getClientBalanceIncreaseStatement(int clientId, float value, Connection dbConnection) throws SQLException{
        PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE client SET balance = balance + ? WHERE id = ?");

        pstmt.setFloat(1, value);
        pstmt.setInt(2, clientId);
        
        return pstmt;
    }
    
}
