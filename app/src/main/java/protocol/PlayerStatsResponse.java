package protocol;

import java.io.Serializable;

public class PlayerStatsResponse implements Serializable {
    private  String playerId;
    private double currentBalance;
    private double totalProfitLoss;

    public PlayerStatsResponse(String playerId, double currentBalance,double totalProfitLoss){
        this.playerId = playerId;
        this.currentBalance = currentBalance;
        this.totalProfitLoss = totalProfitLoss;
    }

    public String getPlayerId() {
        return playerId;
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public double getTotalProfitLoss(){
        return totalProfitLoss;
    }
}
