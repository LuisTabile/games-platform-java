package games.platform.models;

public class Client {
    
    private final int id;
    private final String name;
    private final float balance;

    public Client(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
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
     * Get the value of balance
     *
     * @return the value of balance
     */
    public float getBalance() {
        return balance;
    }
    
}
