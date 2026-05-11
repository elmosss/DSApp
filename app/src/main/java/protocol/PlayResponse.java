package protocol;

import shared.Bets;
import java.io.Serializable;

public class PlayResponse implements Serializable {
    private final boolean success;
    private final String message;
    private final Bets betResult;
    private double currentBalance;

    public PlayResponse(boolean success, String message, Bets betResult, double currentBalance) {
        this.success = success;
        this.message = message;
        this.betResult = betResult;
        this.currentBalance = currentBalance;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Bets getBetResult() {
        return betResult;
    }

    public double getCurrentBalance(){return currentBalance;}
}