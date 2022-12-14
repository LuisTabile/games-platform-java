package games.platform.crud.models;

import games.platform.logger.AppLogger;
import games.platform.utils.LoggerGlobal;
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

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Jogo Inserido: " + game.getName());
            return ("Jogo Inserido");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
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

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Jogo Atualizado: " + game.getName());
            return ("Jogo Atualizado");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
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

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Jogo Removido: " + game.getName());
            return ("Jogo Removido");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

    public static String removedGames(games.platform.models.Game game, Connection dbConnection) throws SQLException {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO removedGames VALUES (null, ?)")) {
            pstmt.setString(1, game.getName());
            pstmt.setInt(2, game.getId());
            return ("Jogo removido da lista");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

}
