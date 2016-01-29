package com.bubbletastic.android.appia.ads.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Created by brendanmartens on 1/28/16.
 * A model object to hold the individual xml responses from the appia ads service.
 */
@Root(name = "ad")
public class Advertisement {

    @Element
    private String appId;

    @Element
    private Integer campaignId;
    @Element
    private Integer campaignTypeId;
    @Element
    private Integer campaignDisplayOrder;

    @Element
    private Integer productId;
    @Element
    private String productName;
    @Element
    private String productThumbnail;
    @Element
    private String productDescription;

    //This appears to be a currency value, so use a BigDecimal
    @Element
    private BigDecimal bidRate;

    @Element
    private Boolean isRandomPick;
    @Element
    private String callToAction;
    @Element
    private String categoryName;
    @Element
    private Integer creativeId;
    @Element
    private String averageRatingImageURL;
    @Element
    private String clickProxyURL;
    @Element(required = false)
    private String minOSVersion;
    @Element
    private Double rating;
    @Element
    private String impressionTrackingURL;
    @Element
    private Boolean homeScreen;
    @Element
    private String numberOfRatings;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(Integer campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public Integer getCampaignDisplayOrder() {
        return campaignDisplayOrder;
    }

    public void setCampaignDisplayOrder(Integer campaignDisplayOrder) {
        this.campaignDisplayOrder = campaignDisplayOrder;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getBidRate() {
        return bidRate;
    }

    public void setBidRate(BigDecimal bidRate) {
        this.bidRate = bidRate;
    }

    public Boolean getIsRandomPick() {
        return isRandomPick;
    }

    public void setIsRandomPick(Boolean isRandomPick) {
        this.isRandomPick = isRandomPick;
    }

    public String getCallToAction() {
        return callToAction;
    }

    public void setCallToAction(String callToAction) {
        this.callToAction = callToAction;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(Integer creativeId) {
        this.creativeId = creativeId;
    }

    public String getAverageRatingImageURL() {
        return averageRatingImageURL;
    }

    public void setAverageRatingImageURL(String averageRatingImageURL) {
        this.averageRatingImageURL = averageRatingImageURL;
    }

    public String getClickProxyURL() {
        return clickProxyURL;
    }

    public void setClickProxyURL(String clickProxyURL) {
        this.clickProxyURL = clickProxyURL;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public void setMinOSVersion(String minOSVersion) {
        this.minOSVersion = minOSVersion;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImpressionTrackingURL() {
        return impressionTrackingURL;
    }

    public void setImpressionTrackingURL(String impressionTrackingURL) {
        this.impressionTrackingURL = impressionTrackingURL;
    }

    public Boolean getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(Boolean homeScreen) {
        this.homeScreen = homeScreen;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(String numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "appId='" + appId + '\'' +
                ", campaignId=" + campaignId +
                ", campaignTypeId=" + campaignTypeId +
                ", campaignDisplayOrder=" + campaignDisplayOrder +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productThumbnail='" + productThumbnail + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", bidRate=" + bidRate +
                ", isRandomPick=" + isRandomPick +
                ", callToAction='" + callToAction + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", creativeId=" + creativeId +
                ", averageRatingImageURL='" + averageRatingImageURL + '\'' +
                ", clickProxyURL='" + clickProxyURL + '\'' +
                ", minOSVersion='" + minOSVersion + '\'' +
                ", rating=" + rating +
                ", impressionTrackingURL='" + impressionTrackingURL + '\'' +
                ", homeScreen=" + homeScreen +
                ", numberOfRatings='" + numberOfRatings + '\'' +
                '}';
    }

    @Override
    @SuppressWarnings("RedundantIfStatement")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        if (!appId.equals(that.appId)) return false;
        if (!campaignId.equals(that.campaignId)) return false;
        if (!campaignTypeId.equals(that.campaignTypeId)) return false;
        if (!productId.equals(that.productId)) return false;
        if (!categoryName.equals(that.categoryName)) return false;
        if (!creativeId.equals(that.creativeId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appId.hashCode();
        result = 31 * result + campaignId.hashCode();
        result = 31 * result + campaignTypeId.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + creativeId.hashCode();
        return result;
    }
}
