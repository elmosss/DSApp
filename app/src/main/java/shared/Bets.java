package shared;

import java.io.Serializable;

public class Bets implements Serializable {

    private String playerId;
    private String gameName;
    private String providerName;
    private double betAmount;
    private double multiplier;
    private double profitLoss;
    private boolean isJackpot;


    public Bets(String playerId, String gameName, String providerName, double betAmount, double multiplier, double profitLoss, boolean isJackpot) {
        this.playerId = playerId;
        this.gameName = gameName;
        this.providerName = providerName;
        this.betAmount = betAmount;
        this.multiplier = multiplier;
        this.profitLoss = profitLoss;
        this.isJackpot = isJackpot;
    }


    public String  getPlayerId() { return playerId; }
    public String  getGameName() { return gameName; }
    public String  getProviderName() { return providerName; }
    public double  getBetAmount() { return betAmount; }
    public double  getMultiplier() { return multiplier; }
    public double  getProfitLoss() { return profitLoss; }
    public boolean isJackpot() { return isJackpot; }


    @Override
    public String toString() {
        return "[Player: " + playerId + " | Game: " + gameName + " | Bet: " + betAmount +
                " | Multiplier: " + multiplier + " | P/L: " + profitLoss + " | Jackpot: " + isJackpot + "]";
    }
}