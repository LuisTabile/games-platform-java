package games.platform.actions;

import games.platform.dbModels.Buys;
import games.platform.dbModels.Clients;
import games.platform.logger.AppLogger;
import games.platform.models.Client;
import games.platform.models.Game;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientActions {

    public static String buyOneGame(Client client, Game game, Connection dbConnection) {
        if (client.getBalance() < game.getPrice()) {
            return ("Cliente não tem saldo suficiente para compra");
        }
        try {
            dbConnection.setAutoCommit(false);

            PreparedStatement balancePdStt = Clients.getClientBalanceDecreaseStatement(client.getId(), game.getPrice(), dbConnection);
            PreparedStatement buyPdStt = Buys.getBuyStatement(client.getId(), game.getId(), dbConnection);

            balancePdStt.executeUpdate();
            buyPdStt.executeUpdate();

            dbConnection.commit();
            dbConnection.setAutoCommit(true);

            balancePdStt.close();
            buyPdStt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Compra Finalizada - Cliente:" + client.getName()+", Jogo: "+ game.getName());
            return ("Compra Finalizada");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

}
