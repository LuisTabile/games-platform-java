package games.plataform.dbModels;

public class Clients {

    /**
     * Get the query string to get all clients
     *
     * @return all clients
     */
    public static String getClients() {
        return "SELECT * FROM client";
    }
    
    /**
     * Get the query string to get all clients with all games
     *
     * @return all clients with all games
     */
    public static String getClientsWithGames() {
        return "SELECT * FROM client JOIN compra ON (client.id = compra.client_id) JOIN game ON (game.id = compra.game_id)";
    }
    
    /**
     * Get the query string to get client with all games
     *
     * @param clientId client id to get the games
     * @return client with all games
     */
    public static String getClientsWithGames(int clientId) {
        return getClientsWithGames().concat(" WHERE client.id = " + clientId);
    }
    
}
