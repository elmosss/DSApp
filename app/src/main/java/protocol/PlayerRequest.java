package protocol;

import shared.Player;

import java.io.Serializable;

public class PlayerRequest implements Serializable {
    private String action;   // "SIGN_UP", "ADD_BALANCE", "FIND_PLAYER"
    private Player player;
    private double amount;

    public PlayerRequest(String action, Player player, double amount) {
        this.action = action;
        this.player = player;
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public Player getPlayer() {
        return player;
    }

    public double getAmount() {
        return amount;
    }
}
