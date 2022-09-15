package games.plataform.dbModels;

public class Clients {
    
    /**
     * Get the query string to get all clients
     *
     * @return all clients
     */
    public static String getClients(){
        return "SELECT * FROM client";
    }
    
}
