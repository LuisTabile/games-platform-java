package games.plataform.models;

import java.util.Date;

public class Game {
    
    private final int id;
    private final int publisher_id;
    private final String publisher_name;
    private final String name;
    private final String description;
    private final Date releaseDate;
    private final float price;

    public Game(int id, String name, String description, Date releaseDate, float price, int publisher_id, String publisher_name) {
        this.id = id;
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.price = price;
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
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Get the value of releaseDate
     *
     * @return the value of releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }
    
    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * Get the value of publisher_id
     *
     * @return the value of publisher_id
     */
    public int getPublisherId() {
        return publisher_id;
    }
    
    /**
     * Get the value of publisher_name
     *
     * @return the value of publisher_name
     */
    public String getPublisherName() {
        return publisher_name;
    }
}
