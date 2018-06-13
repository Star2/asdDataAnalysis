package com.aisidi.analysis.core.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.aisidi.analysis.core.common.ProductParam;
import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ProductOffer;
import com.aisidi.analysis.core.model.SelfHandle;
import com.aisidi.analysis.core.model.dto.UserFlowDTO;
import com.aisidi.analysis.core.service.AbstractService;
import com.aisidi.analysis.core.service.GearService;
import com.aisidi.analysis.core.service.core.ChangeHistoryService;
import com.aisidi.analysis.core.service.core.SelfHandleService;
import com.aisidi.analysis.core.service.core.UserFlowInfoService;
import com.aisidi.analysis.util.CalculationUtil;
import com.aisidi.analysis.util.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service("gearService")
public class GearServiceImpl extends AbstractService implements GearService{

	@Autowired
	@Qualifier("userFlowInfoService")
	private UserFlowInfoService userFlowInfoService;
	
	@Autowired
	private SelfHandleService selfHandleService ;
	
	@Autowired
	private ChangeHistoryService changeHistoryService ;
	
	@Override
	public void rise(String month) throws ParseException {
		
		Integer lastMonth = DateUtil.addMonths(month, -1);
		Integer llastMonth = DateUtil.addMonths(month, -2);
		//升降档集合
		Map<String ,ChangeHistory> riseOrGrop = new HashMap<String ,ChangeHistory>();
		//不升不降回调集合
		Map<String ,String> noRiseOrGrop = new HashMap<String ,String>();
		//分页 并根据手机号分组查询出近三月的记录
		int count = userFlowInfoService.queryUserFlowCount(Integer.parseInt(month), lastMonth, llastMonth);
		int pageSize = 100;
		int countPage =  getTotalPage(count, pageSize);
		for(int i = 0 ;i < countPage ; i++) {
			int startPage = i * pageSize ;
			int endPage = (i + 1) * pageSize;
			//使用分页插件,核心代码就这一行
			Page page = PageHelper.startPage(startPage, endPage ,false);
			//false ,不查总数，减少一次查询
			List<UserFlowDTO> userFlowList = userFlowInfoService.queryUserFlow(Integer.parseInt(month) ,lastMonth ,llastMonth ,startPage ,endPage);
			
			for(UserFlowDTO userFlowDTO :userFlowList) {
				//计算升档
				rise(userFlowDTO ,riseOrGrop ,noRiseOrGrop);
				//计算降档
				grop(userFlowDTO ,riseOrGrop ,noRiseOrGrop);
			}
			//合并计算升降档
			calculateRiseAndGrop(riseOrGrop, month);
			//不升不降回调
			callBack(noRiseOrGrop);
		}
		
	}
	
	private void callBack(Map<String, String> noRiseOrGrop) {
		Set<String> sets = noRiseOrGrop.keySet();
		for(String phone : sets) {
			String offerId = noRiseOrGrop.get(phone) ;
			ChangeHistory history = changeHistoryService.queryByPhoneDesc(phone);
			//不等于当前档位，回调
			if(history != null && !history.getNewOfferId().equals(offerId)) {
				//回调
				history.setNewOfferId(offerId);
				history.setChangeTime(new Date());
				changeHistoryService.updateByPrimaryKeySelective(history);
			}
		}
	}



	private void calculateRiseAndGrop(Map<String ,ChangeHistory> riseOrGrop ,String month) {
		Set<String> sets = riseOrGrop.keySet();
		for(String phone : sets) {
			//查询是否自助变更
			List<SelfHandle> handles = selfHandleService.queryByPhoneAndTime(phone , month);
			//自助变更不为空那么就删除掉
			if(!CollectionUtils.isEmpty(handles)) {
				riseOrGrop.remove(phone);
				return ;
			}
			//查询历史表是否已经变更过
			ChangeHistory history = changeHistoryService.queryByPhoneDesc(phone);
			if(history  == null) {
				//初次变更表
				changeHistoryService.insert(riseOrGrop.get(phone));
			}else {
				//已经变更过，判断是否当前需要变更的档位相同
				history.setNewOfferId(riseOrGrop.get(phone).getNewOfferId());
				history.setChangeTime(riseOrGrop.get(phone).getChangeTime());
				changeHistoryService.updateByPrimaryKeySelective(history);
			}
			
		}
	}

	private void grop(UserFlowDTO userFlowDTO ,Map<String ,ChangeHistory> riseOrGrop ,Map<String ,String> noRiseOrGrop) throws ParseException {
		String useds = userFlowDTO.getTraffics() ;
		String [] usedsArray = useds.split(",");
		if(usedsArray.length != 3) {  //最近三个月都有数据那么继续向下，不然跳出
			return  ;
		}
		//近3月套餐ID
		String [] productArray = userFlowDTO.getProducts().split(",");
		//本月套餐
		ProductOffer productOffer = ProductParam.getProduct(productArray[2]);
		BigDecimal blastUsed = new BigDecimal( usedsArray[0]);
		BigDecimal lastUsed = new BigDecimal( usedsArray[1]);
		BigDecimal nowUsed = new BigDecimal( usedsArray[2]);
		
		//(流量>limit_low) == 1|0
		int count = 0 ;
		if(nowUsed.compareTo(new BigDecimal(productOffer.getOfferLowerLimit())) == 1) {
			count++ ;
		}
		if(lastUsed.compareTo(new BigDecimal(productOffer.getOfferLowerLimit())) == 1) {
			count++ ;
		}
		if(blastUsed.compareTo(new BigDecimal(productOffer.getOfferLowerLimit())) == 1) {
			count++ ;
		}
		if(count > 1) {
			return ;
		}
		
		//max(now,last,blast) < limit_low
		boolean flag = CalculationUtil.maxCheck(nowUsed, lastUsed, blastUsed, new BigDecimal(productOffer.getOfferLowerLimit()));
		if(!flag) return ;
		
		//max(now,last,blast) = now ?
		BigDecimal sum = null ;
		//本月使用最多
		if(CalculationUtil.bigThan(nowUsed, lastUsed) && CalculationUtil.bigThan(nowUsed, blastUsed)) {
			sum = nowUsed ;
		}else {
			sum = CalculationUtil.deleteMaxAvg(nowUsed, lastUsed, blastUsed) ;
		}
		productOffer = ProductParam.checkProduct(sum);
		//调档的档位不是当前档位
		if(!productArray[2].equals(productOffer.getProductOfferId())) {
			//升档不包括的前提下加入降档集合中
			if(!riseOrGrop.containsKey(userFlowDTO.getPhoneNo())) {
				String [] changeDateArray = userFlowDTO.getChangeDate().split(",");
				/* ,changeDateArray[2]*/
				ChangeHistory changeHistory = new ChangeHistory(userFlowDTO.getPhoneNo() ,productArray[2] ,productOffer.getProductOfferId());
				riseOrGrop.put(userFlowDTO.getPhoneNo(), changeHistory);
			}
		}else { //否则加入不升不降集合
			noRiseOrGrop.put(userFlowDTO.getPhoneNo() ,productArray[2]);
		}
	}

	/**
	 * 升档模型
	 * @param userFlowDTO
	 * @param riseOrGrop
	 * @param noRiseOrGrop
	 * @throws ParseException
	 */
	public void rise(UserFlowDTO userFlowDTO ,Map<String ,ChangeHistory> riseOrGrop ,Map<String ,String> noRiseOrGrop) throws ParseException {
		//使用流量
		String useds = userFlowDTO.getTraffics() ;
		String [] usedsArray = useds.split(",");

		//最近三个月都有数据那么继续向下，不然跳出
		if(usedsArray.length != 3) {
			return  ;
		}
		//本月和上月流量使用必须都大于0
		if(StringUtils.isEmpty(usedsArray[1]) || StringUtils.isEmpty(usedsArray[2])) {
			return ;
		}
		//上月流量  > 0
		BigDecimal lastUsed = new BigDecimal( usedsArray[1]);
		boolean flag = CalculationUtil.bigThan(lastUsed , BigDecimal.ZERO);
		if(!flag) return ;
		//本月流量  > 0 
		BigDecimal nowUsed = new BigDecimal( usedsArray[2]);
		flag = CalculationUtil.bigThan(nowUsed , BigDecimal.ZERO);
		if(!flag) return ;
		
		// avg(now+last) > limit_high
		//近3月套餐ID
		String [] productArray = userFlowDTO.getProducts().split(",");
		ProductOffer productOffer = ProductParam.getProduct(productArray[2]);
		flag = CalculationUtil.avgCheck(nowUsed, lastUsed, new BigDecimal(productOffer.getOfferLowerLimit()));
		if(!flag) return ;
		
		//now > 25% * sum(last + b_last)
		BigDecimal blast = new BigDecimal(usedsArray[0]) ;
		flag = CalculationUtil.sum(nowUsed ,lastUsed, blast, new BigDecimal("0.25"));
		if(!flag) return ;

		//avg(now + last)匹配的档位
		productOffer = ProductParam.checkProduct(CalculationUtil.avg(nowUsed, lastUsed));
		//调档的档位不匹配当前档位加入升降档集合
		if(!productArray[2].equals(productOffer.getProductOfferId())) {
			String [] changeDateArray = userFlowDTO.getChangeDate().split(",");
			/*,changeDateArray[2]*/
			ChangeHistory changeHistory = new ChangeHistory(userFlowDTO.getPhoneNo() ,productArray[2] ,productOffer.getProductOfferId());
			riseOrGrop.put(userFlowDTO.getPhoneNo(), changeHistory);
		}else { //否则加入不升不降集合
			noRiseOrGrop.put(userFlowDTO.getPhoneNo() ,productArray[2]);
		}
	}
}
