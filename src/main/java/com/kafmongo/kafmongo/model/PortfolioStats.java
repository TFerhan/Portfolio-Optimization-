package com.kafmongo.kafmongo.model;



import java.util.Map;

public class PortfolioStats {
    private long timestamp; // epoch millis
    private Map<CharSequence, Double> meanReturns; 
    private Map<CharSequence, Map<CharSequence, Double>> covarianceMatrix; 

    public PortfolioStats() {}

    public PortfolioStats(long timestamp,
                          Map<CharSequence, Double> meanReturns,
                          Map<CharSequence, Map<CharSequence, Double>> covarianceMatrix) {
        this.timestamp = timestamp;
        this.meanReturns = meanReturns;
        this.covarianceMatrix = covarianceMatrix;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<CharSequence, Double> getMeanReturns() {
        return meanReturns;
    }

    public void setMeanReturns(Map<CharSequence, Double> meanReturns) {
        this.meanReturns = meanReturns;
    }

    public Map<CharSequence, Map<CharSequence, Double>> getCovarianceMatrix() {
        return covarianceMatrix;
    }

    public void setCovarianceMatrix(Map<CharSequence, Map<CharSequence, Double>> covarianceMatrix) {
        this.covarianceMatrix = covarianceMatrix;
    }

    @Override
    public String toString() {
        return "PortfolioStats{" +
                "timestamp=" + timestamp +
                ", meanReturns=" + meanReturns +
                ", covarianceMatrix=" + covarianceMatrix +
                '}';
    }
}

