
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
    "total",
    "offset",
    "limit",
    "order",
    "base",
    "totalMarkets",
    "totalExchanges",
    "totalMarketCap",
    "total24hVolume"
})
public class Stats implements Serializable
{

    @JsonProperty("total")
    private Long total;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("limit")
    private Long limit;
    @JsonProperty("order")
    private String order;
    @JsonProperty("base")
    private String base;
    @JsonProperty("totalMarkets")
    private Long totalMarkets;
    @JsonProperty("totalExchanges")
    private Long totalExchanges;
    @JsonProperty("totalMarketCap")
    private Double totalMarketCap;
    @JsonProperty("total24hVolume")
    private Double total24hVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2382162702543225042L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param total
     * @param offset
     * @param totalExchanges
     * @param limit
     * @param totalMarkets
     * @param totalMarketCap
     * @param total24hVolume
     * @param order
     * @param base
     */
    public Stats(Long total, Long offset, Long limit, String order, String base, Long totalMarkets, Long totalExchanges, Double totalMarketCap, Double total24hVolume) {
        super();
        this.total = total;
        this.offset = offset;
        this.limit = limit;
        this.order = order;
        this.base = base;
        this.totalMarkets = totalMarkets;
        this.totalExchanges = totalExchanges;
        this.totalMarketCap = totalMarketCap;
        this.total24hVolume = total24hVolume;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
        this.total = total;
    }

    public Stats withTotal(Long total) {
        this.total = total;
        return this;
    }

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Stats withOffset(Long offset) {
        this.offset = offset;
        return this;
    }

    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Stats withLimit(Long limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    public Stats withOrder(String order) {
        this.order = order;
        return this;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    public Stats withBase(String base) {
        this.base = base;
        return this;
    }

    @JsonProperty("totalMarkets")
    public Long getTotalMarkets() {
        return totalMarkets;
    }

    @JsonProperty("totalMarkets")
    public void setTotalMarkets(Long totalMarkets) {
        this.totalMarkets = totalMarkets;
    }

    public Stats withTotalMarkets(Long totalMarkets) {
        this.totalMarkets = totalMarkets;
        return this;
    }

    @JsonProperty("totalExchanges")
    public Long getTotalExchanges() {
        return totalExchanges;
    }

    @JsonProperty("totalExchanges")
    public void setTotalExchanges(Long totalExchanges) {
        this.totalExchanges = totalExchanges;
    }

    public Stats withTotalExchanges(Long totalExchanges) {
        this.totalExchanges = totalExchanges;
        return this;
    }

    @JsonProperty("totalMarketCap")
    public Double getTotalMarketCap() {
        return totalMarketCap;
    }

    @JsonProperty("totalMarketCap")
    public void setTotalMarketCap(Double totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public Stats withTotalMarketCap(Double totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
        return this;
    }

    @JsonProperty("total24hVolume")
    public Double getTotal24hVolume() {
        return total24hVolume;
    }

    @JsonProperty("total24hVolume")
    public void setTotal24hVolume(Double total24hVolume) {
        this.total24hVolume = total24hVolume;
    }

    public Stats withTotal24hVolume(Double total24hVolume) {
        this.total24hVolume = total24hVolume;
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

    public Stats withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("offset", offset).append("limit", limit).append("order", order).append("base", base).append("totalMarkets", totalMarkets).append("totalExchanges", totalExchanges).append("totalMarketCap", totalMarketCap).append("total24hVolume", total24hVolume).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(offset).append(totalExchanges).append(limit).append(totalMarkets).append(totalMarketCap).append(total24hVolume).append(additionalProperties).append(order).append(base).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stats) == false) {
            return false;
        }
        Stats rhs = ((Stats) other);
        return new EqualsBuilder().append(total, rhs.total).append(offset, rhs.offset).append(totalExchanges, rhs.totalExchanges).append(limit, rhs.limit).append(totalMarkets, rhs.totalMarkets).append(totalMarketCap, rhs.totalMarketCap).append(total24hVolume, rhs.total24hVolume).append(additionalProperties, rhs.additionalProperties).append(order, rhs.order).append(base, rhs.base).isEquals();
    }

}
