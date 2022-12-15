package games.platform.dbModels;

import games.platform.logger.AppLogger;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Games {

    /**
     * Get the query string to get all games from all publishers
     *
     * @return all games from all publishers
     */
    public static String getGames() {
        return "SELECT g.id, g.name, g.description, g.release_date, g.price, g.publisher_id, p.name as publisher_name FROM game as g INNER JOIN publisher as p ON (g.publisher_id = p.id)";
    }

    /**
     * Get the query string to get all games from one publishers
     *
     * @param publisherId publisher id to get the games
     * @return all games from the publisher
     */
    public static String getGames(int publisherId) {
        return getGames().concat(" WHERE publisher.id = " + publisherId);
    }

    public static String getRemovedGames() {
        return "SELECT * from removedGames;";
    }

    public static String updateRemovedGames(games.platform.models.Game game, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT into removedGames (1, ?, ?)")) {
            pstmt.setInt(1, game.getId());
            pstmt.setString(2, game.getName());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Jogo adicionado a lista de removidos: " + game.getName());
            return ("Jogo adicionado a lista de removidos");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }
}
