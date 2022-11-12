package games.platform.models;

public class Deposit {

    private final int client_id;
    private final float deposit_value;

    public Deposit(int client_id, float deposit_value) {
        this.client_id = client_id;
        this.deposit_value = deposit_value;
    }

    /**
     * Get the value of client id
     *
     * @return the value of client id
     */
    public int getClientId() {
        return client_id;
    }

    /**
     * Get the value of deposit value
     *
     * @return the value of deposit value
     */
    public float getDepositValue() {
        return deposit_value;
    }

}
