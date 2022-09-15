package games.plataform.models;

import java.util.ArrayList;

public class Publisher {
    
    private final int id;
    private final String name;
    private final ArrayList<Game> games;

    public Publisher(int id, String name, ArrayList<Game> games) {
        this.id = id;
        this.name = name;
        this.games = games;
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    
}
