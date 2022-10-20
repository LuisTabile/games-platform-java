package games.platform.models;

public class Client {
    
    private final int id;
    private String name;
    private float balance;

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
     * Set the value of name
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of balance
     *
     * @return the value of balance
     */
    public float getBalance() {
        return balance;
    }
    
    /**
     * Set the value of balance
     *
     * @param balance the value of balance
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }
}
