package com.aisidi.analysis.core.mapper;

import com.aisidi.analysis.core.model.ProductOffer;

public interface ProductOfferMapper {
    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);
}