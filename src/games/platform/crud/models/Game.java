package games.platform.crud.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Game {

    /**
     * Create game in the database
     *
     * @param game game to be created
     * @param dbConnection database connection
     * @return message
     */
    public static String createGame(games.platform.models.Game game, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO game VALUES (null, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, game.getName());
            pstmt.setString(2, game.getDescription());
            pstmt.setDate(3, new java.sql.Date(game.getReleaseDate().getTime()));
            pstmt.setFloat(4, game.getPrice());
            pstmt.setInt(5, game.getPublisherId());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Jogo Inserido");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }
    
    /**
     * Get the query string to get all clients
     *
     * @param game game with new informations
     * @param dbConnection database connection
     * @return message
     */
    public static String updateGame(games.platform.models.Game game, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE game SET name = ?, description = ?, price = ? WHERE id = ?")) {
            pstmt.setString(1, game.getName());
            pstmt.setString(2, game.getDescription());
            pstmt.setFloat(3, game.getPrice());
            pstmt.setInt(4, game.getId());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Jogo Atualizado");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }
    
    /**
     * Remove game from the database
     *
     * @param game game to be removed
     * @param dbConnection database connection
     * @return message
     */
    public static String removeGame(games.platform.models.Game game, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("DELETE FROM game WHERE id = ?")) {
            pstmt.setInt(1, game.getId());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Jogo Removido");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }

}
