package games.plataform.dbModels;

public class Games {
    
    public static String getGames(){
        return "SELECT * FROM game INNER JOIN publisher ON (game.publisher_id === publisher.id)";
    }
    
    public static String getGames(int publisherId){
        return "SELECT * FROM game INNER JOIN publisher ON (game.publisher_id === publisher.id) WHERE publisher.id === " + publisherId;
    }
    
}
