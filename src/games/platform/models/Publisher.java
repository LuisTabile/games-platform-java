package games.platform.models;

import java.util.ArrayList;

public class Publisher {
    
    private final int id;
    private String name;
    private final ArrayList<Game> games;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
        this.games = new ArrayList<>();
    }
    
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
    
    /**
     * Set the value of name
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
}
