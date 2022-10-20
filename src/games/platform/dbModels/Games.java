package games.platform.dbModels;

public class Games {
    
    /**
     * Get the query string to get all games from all publishers
     *
     * @return all games from all publishers
     */
    public static String getGames(){
        return "SELECT g.id, g.name, g.description, g.release_date, g.price, g.publisher_id, p.name as publisher_name FROM game as g INNER JOIN publisher as p ON (g.publisher_id = p.id)";
    }
    
    /**
     * Get the query string to get all games from one publishers
     *
     * @param publisherId publisher id to get the games
     * @return all games from the publisher
     */
    public static String getGames(int publisherId){
        return getGames().concat(" WHERE publisher.id = " + publisherId);
    }
    
}
