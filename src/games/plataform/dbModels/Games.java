package games.plataform.dbModels;

public class Games {
    
    /**
     * Get the query string to get all games from all publishers
     *
     * @return all games from all publishers
     */
    public static String getGames(){
        return "SELECT * FROM game INNER JOIN publisher ON (game.publisher_id === publisher.id)";
    }
    
    /**
     * Get the query string to get all games from one publishers
     *
     * @param publisherId publisher id to get the games
     * @return all games from the publisher
     */
    public static String getGames(int publisherId){
        return "SELECT * FROM game INNER JOIN publisher ON (game.publisher_id === publisher.id) WHERE publisher.id === " + publisherId;
    }
    
}
