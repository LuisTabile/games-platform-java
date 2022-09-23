package games.plataform.dbModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Buys {
    
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
