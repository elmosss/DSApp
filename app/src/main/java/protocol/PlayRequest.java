package protocol;

import shared.Player;

import java.io.Serializable;

public class PlayRequest implements Serializable {
    private Player player;
    private final String gameName;
    private final double betAmount;

    public PlayRequest(Player player, String gameName, double betAmount) {
        this.player = player;
        this.gameName = gameName;
        this.betAmount = betAmount;
    }
    public Player getPlayer() {
        return player;
    }

    public String getGameName() {
        return gameName;
    }

    public double getBetAmount() {
        return betAmount;
    }
}