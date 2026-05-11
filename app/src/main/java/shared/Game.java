package shared;

import java.io.Serializable;

public class Game implements Serializable {

    private String gameName;
    private String providerName;
    private double stars;
    private int votes;
    private double minBet;
    private double maxBet;
    private String riskLevel;
    private String gameLogo;
    private String hashKey;

    private String betCategory;
    private double jackpot;

    private boolean isActive;

    public Game(String gameName, String providerName, double stars, int votes, double minBet, double maxBet, String riskLevel, String gameLogo, String hashKey) {

        validate(gameName, providerName, stars, votes, minBet, maxBet, riskLevel, gameLogo, hashKey);

        this.gameName = gameName;
        this.providerName = providerName;
        this.stars = stars;
        this.votes = votes;
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.riskLevel = riskLevel;
        this.gameLogo = gameLogo;
        this.hashKey = hashKey;
        this.isActive = true;

        // Game initialization calculations
        findBetCategory();
        calculateJackpot();
    }

    private void validate(String gameName, String providerName, double stars, int votes, double minBet, double maxBet, String riskLevel, String gameLogo, String hashKey) {
        if (gameName == null) {
            throw new IllegalArgumentException("Game name cannot be empty");
        }
        if (providerName == null) {
            throw new IllegalArgumentException("Provider name cannot be empty");
        }
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Stars must be between 1 and 5");
        }
        if (votes < 0) {
            throw new IllegalArgumentException("Votes cannot be less than 0");
        }
        if (minBet < 0.1) {
            throw new IllegalArgumentException("Minimum bet must be at least 0.1");
        }
        if (maxBet < minBet) {
            throw new IllegalArgumentException("Maximum bet must be greater that minimum bet");
        }
        if (!riskLevel.toLowerCase().equals("low") &&
                !riskLevel.toLowerCase().equals("medium") &&
                !riskLevel.toLowerCase().equals("high")) {
            throw new IllegalArgumentException("Invalid risk level: " + riskLevel);
        }
        if (gameLogo == null) {
            throw new IllegalArgumentException("Game logo cannot be empty");
        }
        if (hashKey == null) {
            throw new IllegalArgumentException("Hash key cannot be empty");
        }

    }

    //Bet Category calculation
    private void findBetCategory() {
        if (minBet >= 0.1 && minBet < 1.0) this.betCategory = "$";
        else if (minBet >= 1.0 && minBet < 5.0) this.betCategory = "$$";
        else this.betCategory = "$$$";
    }

    private void calculateJackpot() {
        switch (riskLevel.toLowerCase()) {
            case "low":
                this.jackpot = 10;
                break;
            case "medium":
                this.jackpot = 20;
                break;
            case "high":
                this.jackpot = 40;
                break;
        }
    }

    public double[] getProfitMultipliers() {
        switch (riskLevel.toLowerCase()) {
            case "low":
                return new double[]{0.0, 0.0, 0.0, 0.1, 0.5, 1.0, 1.1, 1.3, 2.0, 2.5};
            case "medium":
                return new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 1.0, 1.5, 2.5, 3.5};
            case "high":
                return new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 2.0, 6.5};
            default:
                throw new IllegalArgumentException("Invalid risk level: " + riskLevel);
        }
    }

    public String getGameName() {
        return gameName;
    }

    public String getProviderName() {
        return providerName;
    }

    public double getStars() {
        return stars;
    }

    public int getVotes() {
        return votes;
    }

    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getGameLogo() {
        return gameLogo;
    }

    public String getHashKey() {
        return hashKey;
    }

    public String getBetCategory() {
        return betCategory;
    }

    public double getJackpot() {
        return jackpot;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
        calculateJackpot();
    }

    @Override
    public String toString() {
        return "[" + gameName + " | " + providerName + " | Stars: " + stars + " | Risk: " + riskLevel +
                " | Bet: " + betCategory + " | Jackpot: " + jackpot + " | Active: " + isActive + "]";
    }
}
