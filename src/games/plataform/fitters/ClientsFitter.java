package games.plataform.fitters;

import games.plataform.dbModels.Clients;
import games.plataform.models.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientsFitter {
    
    /**
     * Get all Clients registered as ArrayList
     *
     * @param connection database Connection
     * @return an ArrayList with all Clients
     */
    public static ArrayList<Client> getAllClients(Connection connection) throws SQLException {
        ArrayList<Client> allClients = new ArrayList<>();
        
        Statement stmt = connection.createStatement();
        
        //Obtém os metadados do resultado
        try (ResultSet resultSet = stmt.executeQuery(Clients.getClients())) {
            //Obtém os metadados do resultado
            
            //percorre os dados retornados pela consulta exibindo-os
            while (resultSet.next()) {
                allClients.add(new Client((int) resultSet.getObject(1), (String) resultSet.getObject(2), (float) resultSet.getObject(3)));
            }
            
            resultSet.close();
            stmt.close();
        }
        
        return allClients;
    }
    
}
