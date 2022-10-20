package games.platform.fitters;

import games.platform.dbModels.Publishers;
import games.platform.models.Publisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PublishersFitter {
    
    /**
     * Get all Publishers registered as ArrayList
     *
     * @param connection database Connection
     * @return an ArrayList with all Publishers
     */
    public static ArrayList<Publisher> getAllPublishers(Connection connection) throws SQLException {
        ArrayList<Publisher> allPublishers = new ArrayList<>();
        
        Statement stmt = connection.createStatement();
        
        //Obtém os metadados do resultado
        try (ResultSet resultSet = stmt.executeQuery(Publishers.getPublishers())) {
            //Obtém os metadados do resultado
            
            //percorre os dados retornados pela consulta exibindo-os
            while (resultSet.next()) {
                allPublishers.add(new Publisher((int) resultSet.getObject(1), (String) resultSet.getObject(2)));
            }
            
            resultSet.close();
            stmt.close();
        }
        
        return allPublishers;
    }
    
}
