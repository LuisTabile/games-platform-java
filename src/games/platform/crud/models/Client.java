package games.platform.crud.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {

    /**
     * Create client in the database
     *
     * @param client client to be created
     * @param dbConnection database connection
     * @return message
     */
    public static String createClient(games.platform.models.Client client, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO client VALUES (null, ?, ?)")) {
            pstmt.setString(1, client.getName());
            pstmt.setFloat(2, client.getBalance());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Cliente Inserido");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }
    
    /**
     * Update client in the database
     *
     * @param client client with new informations
     * @param dbConnection database connection
     * @return message
     */
    public static String updateClient(games.platform.models.Client client, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE client SET name = ?, balance = ? WHERE id = ?")) {
            pstmt.setString(1, client.getName());
            pstmt.setFloat(2, client.getBalance());
            pstmt.setInt(3, client.getId());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Cliente Atualizado");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }
    
    /**
     * Remove client from the database
     *
     * @param client client to be removed
     * @param dbConnection database connection
     * @return message
     */
    public static String removeClient(games.platform.models.Client client, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("DELETE FROM client WHERE id = ?")) {
            pstmt.setInt(1, client.getId());

            pstmt.executeUpdate();
            pstmt.close();

            return ("Cliente Removido");
        } catch (SQLException ex) {
            return ("Erro em: " + ex.getMessage());
        }
    }

}
