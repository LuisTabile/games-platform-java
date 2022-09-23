package games.plataform.fitters;

import games.plataform.dbModels.Games;
import games.plataform.models.Game;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class GamesFitter {
    
    /**
     * Get all Games registered as ArrayList
     *
     * @param connection database Connection
     * @return an ArrayList with all Games
     */
    public static ArrayList<Game> getAllGames(Connection connection) throws SQLException {
        ArrayList<Game> allGames = new ArrayList<>();
        
        Statement stmt = connection.createStatement();
        
        //Obtém os metadados do resultado
        try (ResultSet resultSet = stmt.executeQuery(Games.getGames())) {
            //Obtém os metadados do resultado
            
            //percorre os dados retornados pela consulta exibindo-os
            while (resultSet.next()) {
                allGames.add(new Game(
                        (int) resultSet.getObject(1),
                        (String) resultSet.getObject(2),
                        (String) resultSet.getObject(3),
                        (Date) resultSet.getObject(4),
                        (float) resultSet.getObject(5), 
                        (int) resultSet.getObject(6),
                        (String) resultSet.getObject(8)
                ));
            }
            
            resultSet.close();
            stmt.close();
        }
        
        return allGames;
    }
    
}
