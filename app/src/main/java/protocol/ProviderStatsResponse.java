package protocol;

import java.io.Serializable;

public class ProviderStatsResponse implements Serializable {
    private String providerName;
    private double totalProfitLoss;

    public ProviderStatsResponse(String providerName, double totalProfitLoss) {
        this.providerName = providerName;
        this.totalProfitLoss = totalProfitLoss;
    }

    public String getProviderName() {return providerName;}
    public double getTotalProfitLoss() {return totalProfitLoss;}
}
