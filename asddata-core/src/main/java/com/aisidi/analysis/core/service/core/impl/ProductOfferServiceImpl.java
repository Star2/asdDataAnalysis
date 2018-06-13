package com.aisidi.analysis.core.service.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisidi.analysis.core.mapper.ProductOfferMapper;
import com.aisidi.analysis.core.model.ProductOffer;
import com.aisidi.analysis.core.service.core.ProductOfferService;

@Service("productOfferService")
public class ProductOfferServiceImpl implements ProductOfferService{

	@Autowired
	private ProductOfferMapper productOfferMapper ;
	
	@Override
	public List<ProductOffer> query(){
		return productOfferMapper.query();
	}
}
