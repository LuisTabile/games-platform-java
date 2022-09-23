package games.plataform.dbModels;

public class Publishers {
    
    /**
     * Get the query string to get all publishers
     *
     * @return all publishers
     */
    public static String getPublishers() {
        return "SELECT * FROM publisher";
    }
    
}
