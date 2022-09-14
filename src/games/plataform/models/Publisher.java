package games.plataform.models;

public class Publisher {
    
    private final int id;
    private final String name;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
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
