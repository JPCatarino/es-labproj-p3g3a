package com.l3a.coinRanking.oldmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    public Stats stats;
    public Base base;
    public List<Coin> coin;

    public Data() {
    }

    public Data(Stats stats, Base base, List<Coin> coin) {
        this.stats = stats;
        this.base = base;
        this.coin = coin;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public List<Coin> getCoin() {
        return coin;
    }

    public void setCoin(List<Coin> coin) {
        this.coin = coin;
    }
}
