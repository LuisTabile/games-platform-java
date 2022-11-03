package games.platform.dbModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Buys {
    
    /**
     * Get the query string to get all buys with all games and publishers
     *
     * @return all buys with all games and publishers
     */
    public static String getBuysWithGames() {
        return "SELECT b.id, c.id, c.name, g.id, g.name, g.price, p.id, p.name FROM buy as b INNER JOIN client as c on (b.client_id = c.id) INNER JOIN game as g on (b.game_id = g.id) INNER JOIN publisher as p on (g.publisher_id = p.id);";
    }
    
    /**
     * Get the PreparedStatement to create new buy
     *
     * @param clientId client id to insert into the buy
     * @param gameId game id to insert into the buy
     * @param dbConnection database Connection
     * @return PreparedStatement to create new buy
     */
    public static PreparedStatement getBuyStatement(int clientId, int gameId, Connection dbConnection) throws SQLException{
        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO buy VALUES (null, ?, ?) ");

        pstmt.setInt(1, clientId);
        pstmt.setInt(2, gameId);
        
        return pstmt;
    }
    
}
