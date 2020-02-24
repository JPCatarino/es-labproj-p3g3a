
package com.l3a.coinRanking.models;

import java.io.Serializable;
import java.util.HashMap;
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
    "symbol",
    "sign"
})
public class Base implements Serializable
{

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("sign")
    private String sign;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3612519217169755667L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Base() {
    }

    /**
     * 
     * @param symbol
     * @param sign
     */
    public Base(String symbol, String sign) {
        super();
        this.symbol = symbol;
        this.sign = sign;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Base withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("sign")
    public String getSign() {
        return sign;
    }

    @JsonProperty("sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    public Base withSign(String sign) {
        this.sign = sign;
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

    public Base withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("symbol", symbol).append("sign", sign).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sign).append(symbol).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Base) == false) {
            return false;
        }
        Base rhs = ((Base) other);
        return new EqualsBuilder().append(sign, rhs.sign).append(symbol, rhs.symbol).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
