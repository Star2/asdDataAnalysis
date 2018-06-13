package com.aisidi.analysis.core.mapper;

import java.util.List;

import com.aisidi.analysis.core.model.ProductOffer;

public interface ProductOfferMapper {
    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);
    
    List<ProductOffer> query();
}