package shared;

import java.io.Serializable;

public class Player implements Serializable {

    private String playerId;
    private double balance;

    public Player(String playerId, double balance) {
        this.playerId = playerId;
        this.balance  = balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (this.balance < amount || balance == 0 || amount < 0) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public String getPlayerId() { return playerId; }
    public double getBalance() {return balance; }

    @Override
    public String toString() {
        return "[Player: " + playerId + " | Balance: " + balance + " FUN]";
    }
}
