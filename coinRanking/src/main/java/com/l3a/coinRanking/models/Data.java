
package com.l3a.coinRanking.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stats",
    "base",
    "coins"
})
public class Data implements Serializable
{

    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("base")
    private Base base;
    @JsonProperty("coins")
    private List<Coin> coins = new ArrayList<Coin>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7217626487578053442L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param stats
     * @param coins
     * @param base
     */
    public Data(Stats stats, Base base, List<Coin> coins) {
        super();
        this.stats = stats;
        this.base = base;
        this.coins = coins;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Data withStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    @JsonProperty("base")
    public Base getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(Base base) {
        this.base = base;
    }

    public Data withBase(Base base) {
        this.base = base;
        return this;
    }

    @JsonProperty("coins")
    public List<Coin> getCoins() {
        return coins;
    }

    @JsonProperty("coins")
    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Data withCoins(List<Coin> coins) {
        this.coins = coins;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Data withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stats", stats).append("base", base).append("coins", coins).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(stats).append(coins).append(base).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(stats, rhs.stats).append(coins, rhs.coins).append(base, rhs.base).isEquals();
    }

}
