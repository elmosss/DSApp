package shared;

import java.io.Serializable;

public class Filters implements Serializable {

    private String playerId;
    private double minStars;    // 3.0 -->  3 stars
    private String riskLevel;   // "low" / "medium" / "high" / null = all
    private String betCategory; // "$" / "$$" / "$$$" / null = all

    public Filters(String playerId, double minStars, String riskLevel, String betCategory) {
        this.playerId = playerId;
        this.minStars = minStars;
        this.riskLevel = riskLevel;
        this.betCategory = betCategory;
    }

    public String getPlayerId() { return playerId; }
    public double getMinStars() { return minStars; }
    public String getRiskLevel() { return riskLevel; }
    public String getBetCategory() { return betCategory; }

    @Override
    public String toString() {
        return "[Player: " + playerId + " | MinStars: " + minStars + " | Risk: " + riskLevel + " | BetCategory: " + betCategory + "]";
    }
}