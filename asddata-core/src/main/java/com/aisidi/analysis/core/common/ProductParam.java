package com.aisidi.analysis.core.common;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aisidi.analysis.core.model.ProductOffer;
import com.aisidi.analysis.core.service.core.ProductOfferService;

@Component
public class ProductParam {

	public static Logger logger = LoggerFactory.getLogger(ProductParam.class);

	
	private static Map<String,ProductOffer> params; 
	
	@Autowired
	private static ProductOfferService productOfferService ;
	
	public static ProductOffer getProduct(String id){
		if(params == null) {
			initParam();
		}
		return params.get(id);
		
	}
	private static void initParam() {
		List<ProductOffer> list = productOfferService.query();
		params= new HashMap<String, ProductOffer>(list.size());
		for(ProductOffer param :list) {
			params.put(param.getProductOfferId(), param);
		}
	}
	
	public static ProductOffer checkProduct(BigDecimal used) {
		if(params == null) {
			initParam();
		}
		Collection<ProductOffer> list = params.values();
		for(ProductOffer product: list) {
			if(new BigDecimal(product.getOfferLowerLimit()).compareTo(used) == -1
					&& new BigDecimal(product.getOfferHightLimit()).compareTo(used) == 1) {
				return product;
			}
		}
		logger.info("已使用量[{}],没有匹配的合适套餐" , used);
		throw new RuntimeException("没有匹配的合适套餐"); 
		
	}
	
	@Resource
	public void setProductOfferService(ProductOfferService productOfferService) {
		ProductParam.productOfferService = productOfferService;
	}
	
	
}
