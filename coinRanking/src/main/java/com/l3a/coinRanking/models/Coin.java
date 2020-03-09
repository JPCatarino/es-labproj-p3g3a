
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

import javax.persistence.*;

@Entity
@Table(name = "coin_tbl")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "uuid",
    "slug",
    "symbol",
    "name",
    "description",
    "color",
    "iconType",
    "iconUrl",
    "websiteUrl",
    "socials",
    "links",
    "confirmedSupply",
    "numberOfMarkets",
    "numberOfExchanges",
    "type",
    "volume",
    "marketCap",
    "price",
    "circulatingSupply",
    "totalSupply",
    "approvedSupply",
    "firstSeen",
    "change",
    "rank",
    "history",
    "allTimeHigh",
    "penalty"
})

public class Coin implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="coin_id_seq")
    @JsonProperty("id")
    private Long id;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @Transient
    @JsonProperty("description")
    private String description;
    @JsonProperty("color")
    private String color;
    @JsonProperty("iconType")
    private String iconType;
    @JsonProperty("iconUrl")
    private String iconUrl;
    @JsonProperty("websiteUrl")
    private String websiteUrl;
    @ElementCollection
    @Transient
    @JsonProperty("socials")
    private List<Social> socials = new ArrayList<Social>();
    @ElementCollection
    @Transient
    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    @JsonProperty("confirmedSupply")
    @Transient
    private Boolean confirmedSupply;
    @JsonProperty("numberOfMarkets")
    private Long numberOfMarkets;
    @JsonProperty("numberOfExchanges")
    private Long numberOfExchanges;
    @JsonProperty("type")
    @Column(name="tp")
    private String type;
    @JsonProperty("volume")
    private Long volume;
    @JsonProperty("marketCap")
    private Long marketCap;
    @JsonProperty("price")
    private String price;
    @JsonProperty("circulatingSupply")
    private Long circulatingSupply;
    @JsonProperty("totalSupply")
    private Long totalSupply;
    @Transient
    @JsonProperty("approvedSupply")
    private Boolean approvedSupply;
    @JsonProperty("firstSeen")
    private Long firstSeen;
    @JsonProperty("change")
    @Column(name="`change`")
    private Double change;
    @JsonProperty("rank")
    @Column(name="`rank`")
    private Long rank;
    @ElementCollection
    @Transient
    @JsonProperty("history")
    private List<String> history = new ArrayList<String>();
    @Transient
    @JsonProperty("allTimeHigh")
    private AllTimeHigh allTimeHigh;
    @JsonProperty("penalty")
    @Transient
    private Boolean penalty;
    @ElementCollection
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6586485921748578393L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coin() {
    }

    /**
     * 
     * @param symbol
     * @param color
     * @param penalty
     * @param description
     * @param type
     * @param uuid
     * @param circulatingSupply
     * @param websiteUrl
     * @param allTimeHigh
     * @param price
     * @param iconType
     * @param rank
     * @param links
     * @param approvedSupply
     * @param id
     * @param iconUrl
     * @param socials
     * @param slug
     * @param marketCap
     * @param numberOfMarkets
     * @param confirmedSupply
     * @param totalSupply
     * @param firstSeen
     * @param change
     * @param history
     * @param volume
     * @param name
     * @param numberOfExchanges
     */
    public Coin(Long id, String uuid, String slug, String symbol, String name, String description, String color, String iconType, String iconUrl, String websiteUrl, List<Social> socials, List<Link> links, Boolean confirmedSupply, Long numberOfMarkets, Long numberOfExchanges, String type, Long volume, Long marketCap, String price, Long circulatingSupply, Long totalSupply, Boolean approvedSupply, Long firstSeen, Double change, Long rank, List<String> history, AllTimeHigh allTimeHigh, Boolean penalty) {
        super();
        this.id = id;
        this.uuid = uuid;
        this.slug = slug;
        this.symbol = symbol;
        this.name = name;
        this.description = description;
        this.color = color;
        this.iconType = iconType;
        this.iconUrl = iconUrl;
        this.websiteUrl = websiteUrl;
        this.socials = socials;
        this.links = links;
        this.confirmedSupply = confirmedSupply;
        this.numberOfMarkets = numberOfMarkets;
        this.numberOfExchanges = numberOfExchanges;
        this.type = type;
        this.volume = volume;
        this.marketCap = marketCap;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.approvedSupply = approvedSupply;
        this.firstSeen = firstSeen;
        this.change = change;
        this.rank = rank;
        this.history = history;
        this.allTimeHigh = allTimeHigh;
        this.penalty = penalty;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public Coin withId(Long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Coin withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Coin withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Coin withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Coin withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Coin withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public Coin withColor(String color) {
        this.color = color;
        return this;
    }

    @JsonProperty("iconType")
    public String getIconType() {
        return iconType;
    }

    @JsonProperty("iconType")
    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public Coin withIconType(String iconType) {
        this.iconType = iconType;
        return this;
    }

    @JsonProperty("iconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("iconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Coin withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    @JsonProperty("websiteUrl")
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    @JsonProperty("websiteUrl")
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Coin withWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
        return this;
    }

    @JsonProperty("socials")
    public List<Social> getSocials() {
        return socials;
    }

    @JsonProperty("socials")
    public void setSocials(List<Social> socials) {
        this.socials = socials;
    }

    public Coin withSocials(List<Social> socials) {
        this.socials = socials;
        return this;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Coin withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    @JsonProperty("confirmedSupply")
    public Boolean getConfirmedSupply() {
        return confirmedSupply;
    }

    @JsonProperty("confirmedSupply")
    public void setConfirmedSupply(Boolean confirmedSupply) {
        this.confirmedSupply = confirmedSupply;
    }

    public Coin withConfirmedSupply(Boolean confirmedSupply) {
        this.confirmedSupply = confirmedSupply;
        return this;
    }

    @JsonProperty("numberOfMarkets")
    public Long getNumberOfMarkets() {
        return numberOfMarkets;
    }

    @JsonProperty("numberOfMarkets")
    public void setNumberOfMarkets(Long numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
    }

    public Coin withNumberOfMarkets(Long numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
        return this;
    }

    @JsonProperty("numberOfExchanges")
    public Long getNumberOfExchanges() {
        return numberOfExchanges;
    }

    @JsonProperty("numberOfExchanges")
    public void setNumberOfExchanges(Long numberOfExchanges) {
        this.numberOfExchanges = numberOfExchanges;
    }

    public Coin withNumberOfExchanges(Long numberOfExchanges) {
        this.numberOfExchanges = numberOfExchanges;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Coin withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("volume")
    public Long getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Coin withVolume(Long volume) {
        this.volume = volume;
        return this;
    }

    @JsonProperty("marketCap")
    public Long getMarketCap() {
        return marketCap;
    }

    @JsonProperty("marketCap")
    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Coin withMarketCap(Long marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    public Coin withPrice(String price) {
        this.price = price;
        return this;
    }

    @JsonProperty("circulatingSupply")
    public Long getCirculatingSupply() {
        return circulatingSupply;
    }

    @JsonProperty("circulatingSupply")
    public void setCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Coin withCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
        return this;
    }

    @JsonProperty("totalSupply")
    public Long getTotalSupply() {
        return totalSupply;
    }

    @JsonProperty("totalSupply")
    public void setTotalSupply(Long totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Coin withTotalSupply(Long totalSupply) {
        this.totalSupply = totalSupply;
        return this;
    }

    @JsonProperty("approvedSupply")
    public Boolean getApprovedSupply() {
        return approvedSupply;
    }

    @JsonProperty("approvedSupply")
    public void setApprovedSupply(Boolean approvedSupply) {
        this.approvedSupply = approvedSupply;
    }

    public Coin withApprovedSupply(Boolean approvedSupply) {
        this.approvedSupply = approvedSupply;
        return this;
    }

    @JsonProperty("firstSeen")
    public Long getFirstSeen() {
        return firstSeen;
    }

    @JsonProperty("firstSeen")
    public void setFirstSeen(Long firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Coin withFirstSeen(Long firstSeen) {
        this.firstSeen = firstSeen;
        return this;
    }

    @JsonProperty("change")
    public Double getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(Double change) {
        this.change = change;
    }

    public Coin withChange(Double change) {
        this.change = change;
        return this;
    }

    @JsonProperty("rank")
    public Long getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Coin withRank(Long rank) {
        this.rank = rank;
        return this;
    }

    @JsonProperty("history")
    public List<String> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<String> history) {
        this.history = history;
    }

    public Coin withHistory(List<String> history) {
        this.history = history;
        return this;
    }

    @JsonProperty("allTimeHigh")
    public AllTimeHigh getAllTimeHigh() {
        return allTimeHigh;
    }

    @JsonProperty("allTimeHigh")
    public void setAllTimeHigh(AllTimeHigh allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public Coin withAllTimeHigh(AllTimeHigh allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
        return this;
    }

    @JsonProperty("penalty")
    public Boolean getPenalty() {
        return penalty;
    }

    @JsonProperty("penalty")
    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

    public Coin withPenalty(Boolean penalty) {
        this.penalty = penalty;
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

    public Coin withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("uuid", uuid).append("slug", slug).append("symbol", symbol).append("name", name).append("description", description).append("color", color).append("iconType", iconType).append("iconUrl", iconUrl).append("websiteUrl", websiteUrl).append("socials", socials).append("links", links).append("confirmedSupply", confirmedSupply).append("numberOfMarkets", numberOfMarkets).append("numberOfExchanges", numberOfExchanges).append("type", type).append("volume", volume).append("marketCap", marketCap).append("price", price).append("circulatingSupply", circulatingSupply).append("totalSupply", totalSupply).append("approvedSupply", approvedSupply).append("firstSeen", firstSeen).append("change", change).append("rank", rank).append("history", history).append("allTimeHigh", allTimeHigh).append("penalty", penalty).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(symbol).append(color).append(penalty).append(description).append(type).append(uuid).append(circulatingSupply).append(websiteUrl).append(allTimeHigh).append(price).append(iconType).append(rank).append(links).append(approvedSupply).append(id).append(iconUrl).append(socials).append(slug).append(marketCap).append(numberOfMarkets).append(confirmedSupply).append(totalSupply).append(firstSeen).append(change).append(history).append(volume).append(name).append(numberOfExchanges).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Coin) == false) {
            return false;
        }
        Coin rhs = ((Coin) other);
        return new EqualsBuilder().append(symbol, rhs.symbol).append(color, rhs.color).append(penalty, rhs.penalty).append(description, rhs.description).append(type, rhs.type).append(uuid, rhs.uuid).append(circulatingSupply, rhs.circulatingSupply).append(websiteUrl, rhs.websiteUrl).append(allTimeHigh, rhs.allTimeHigh).append(price, rhs.price).append(iconType, rhs.iconType).append(rank, rhs.rank).append(links, rhs.links).append(approvedSupply, rhs.approvedSupply).append(id, rhs.id).append(iconUrl, rhs.iconUrl).append(socials, rhs.socials).append(slug, rhs.slug).append(marketCap, rhs.marketCap).append(numberOfMarkets, rhs.numberOfMarkets).append(confirmedSupply, rhs.confirmedSupply).append(totalSupply, rhs.totalSupply).append(firstSeen, rhs.firstSeen).append(change, rhs.change).append(history, rhs.history).append(volume, rhs.volume).append(name, rhs.name).append(numberOfExchanges, rhs.numberOfExchanges).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
