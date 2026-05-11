package protocol;

import java.io.Serializable;

public class GameStatsResponse implements Serializable {
    private String gameName;
    private double totalProfitLoss;

    public GameStatsResponse(String gameName, double totalProfitLoss) {
        this.gameName = gameName;
        this.totalProfitLoss = totalProfitLoss;
    }

    public String getGameName() {return gameName;}
    public double getTotalProfitLoss() {return totalProfitLoss;}
}