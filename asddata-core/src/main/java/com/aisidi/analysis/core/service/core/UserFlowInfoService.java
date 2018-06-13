package com.aisidi.analysis.core.service.core;

import java.util.List;

import com.aisidi.analysis.core.model.UserFlowInfo;
import com.aisidi.analysis.core.model.UserFlowInfoKey;
import com.aisidi.analysis.core.model.dto.UserFlowDTO;

public interface UserFlowInfoService {

	 public void selectByPrimaryKey(UserFlowInfoKey key);
	 
	 public List<UserFlowDTO> queryUserFlow(Integer month, Integer lastMonth, Integer llastMonth ,long startPag , long endPage);
	 
	 public int queryUserFlowCount(Integer month, Integer lastMonth, Integer llastMonth) ;
}
