package games.platform.crud.models;

import games.platform.logger.AppLogger;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Publisher {

    /**
     * Create publisher in the database
     *
     * @param publisher publisher to be created
     * @param dbConnection database connection
     * @return message
     */
    public static String createPublisher(games.platform.models.Publisher publisher, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO publisher VALUES (null, ?)")) {
            pstmt.setString(1, publisher.getName());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Editora Inserida: " + publisher.getName());
            return ("Editora Inserida");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

    /**
     * Get the query string to get all clients
     *
     * @param publisher publisher with new informations
     * @param dbConnection database connection
     * @return message
     */
    public static String updatePublisher(games.platform.models.Publisher publisher, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE publisher SET name = ? WHERE id = ?")) {
            pstmt.setString(1, publisher.getName());
            pstmt.setInt(2, publisher.getId());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Editora Atualizada: " + publisher.getName());
            return ("Editora Atualizada");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

    /**
     * Remove publisher from the database
     *
     * @param publisher publisher to be removed
     * @param dbConnection database connection
     * @return message
     */
    public static String removePublisher(games.platform.models.Publisher publisher, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("DELETE FROM publisher WHERE id = ?")) {
            pstmt.setInt(1, publisher.getId());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Editora Removida: " + publisher.getName());
            return ("Editora Removida");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

}
