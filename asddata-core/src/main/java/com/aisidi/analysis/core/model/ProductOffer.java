package com.aisidi.analysis.core.model;

public class ProductOffer {
    private String productOfferId;

    private Long offerPrice;

    private String offerValue;

    private String offerLowerLimit;

    private String offerHightLimit;

    public String getProductOfferId() {
        return productOfferId;
    }

    public void setProductOfferId(String productOfferId) {
        this.productOfferId = productOfferId == null ? null : productOfferId.trim();
    }

    public Long getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Long offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOfferValue() {
        return offerValue;
    }

    public void setOfferValue(String offerValue) {
        this.offerValue = offerValue == null ? null : offerValue.trim();
    }

    public String getOfferLowerLimit() {
        return offerLowerLimit;
    }

    public void setOfferLowerLimit(String offerLowerLimit) {
        this.offerLowerLimit = offerLowerLimit == null ? null : offerLowerLimit.trim();
    }

    public String getOfferHightLimit() {
        return offerHightLimit;
    }

    public void setOfferHightLimit(String offerHightLimit) {
        this.offerHightLimit = offerHightLimit == null ? null : offerHightLimit.trim();
    }
}