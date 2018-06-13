package com.aisidi.analysis.core.service.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisidi.analysis.core.mapper.UserFlowInfoMapper;
import com.aisidi.analysis.core.model.UserFlowInfo;
import com.aisidi.analysis.core.model.UserFlowInfoKey;
import com.aisidi.analysis.core.model.dto.UserFlowDTO;
import com.aisidi.analysis.core.service.core.UserFlowInfoService;

@Service("userFlowInfoService")
public class UserFlowInfoServiceImpl implements UserFlowInfoService{

	@Autowired
	private UserFlowInfoMapper userFlowInfoDao ;

	@Override
	public void selectByPrimaryKey(UserFlowInfoKey key) {
		UserFlowInfo flowInfo = userFlowInfoDao.selectByPrimaryKey(key);
		System.out.println(flowInfo);
		
	}
	@Override
	public int queryUserFlowCount(Integer month, Integer lastMonth, Integer llastMonth) {
		return userFlowInfoDao.queryUserFlowCount(month ,lastMonth ,llastMonth);
	}

	@Override
	public List<UserFlowDTO> queryUserFlow(Integer month, Integer lastMonth, Integer llastMonth, long startPag,
			long endPage) {
		return userFlowInfoDao.queryUserFlow(month ,lastMonth ,llastMonth ,startPag ,endPage);
	}
	
}
