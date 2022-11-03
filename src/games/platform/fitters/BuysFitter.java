package games.platform.fitters;

import games.platform.dbModels.Buys;
import games.platform.models.Buy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuysFitter {

    /**
     * Get all Buys registered as ArrayList
     *
     * @param connection database Connection
     * @return an ArrayList with all Buys
     */
    public static ArrayList<Buy> getAllBuys(Connection connection) throws SQLException {
        ArrayList<Buy> allBuys = new ArrayList<>();

        Statement stmt = connection.createStatement();
        //int id, int client_id, String client_name, int game_id, String game_name, int publisher_id, String publisher_name
        //Obtém os metadados do resultado
        try ( ResultSet resultSet = stmt.executeQuery(Buys.getBuysWithGames())) {
            //Obtém os metadados do resultado

            //percorre os dados retornados pela consulta exibindo-os
            while (resultSet.next()) {
                allBuys.add(new Buy(
                        (int) resultSet.getObject(1),
                        (int) resultSet.getObject(2),
                        (String) resultSet.getObject(3),
                        (int) resultSet.getObject(4),
                        (String) resultSet.getObject(5),
                        (float) resultSet.getObject(6),
                        (int) resultSet.getObject(7),
                        (String) resultSet.getObject(8)
                ));
            }

            resultSet.close();
            stmt.close();
        }

        return allBuys;
    }

}
