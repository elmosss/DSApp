package protocol;

import java.io.Serializable;

public class PlayerBalanceResponse implements Serializable {
    double balance;

    public PlayerBalanceResponse(double balance){
        this.balance = balance;
    }

    public double getCurrentBalance(){ return balance;}
}
