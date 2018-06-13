package com.aisidi.analysis.core.service.core.impl;

import com.aisidi.analysis.core.mapper.ChangeHistoryMapper;
import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;
import com.aisidi.analysis.core.service.core.ChangeHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojy
 * @date 2018/5/30
 */
@Service("changeHistoryService")
public class ChangeHistoryServiceImpl implements ChangeHistoryService {

    @Autowired
    ChangeHistoryMapper changeHistoryMapper;
    @Override
    public List<ResultData> selectSelfChange() {
        List list = changeHistoryMapper.selectSelfChange();
        return list;
    }
	@Override
	public ChangeHistory queryByPhoneDesc(String phone) {
		return changeHistoryMapper.queryByPhoneDesc(phone);
	}
	@Override
	public int insert(ChangeHistory history) {
		return changeHistoryMapper.insert(history);
	}
	@Override
	public int updateByPrimaryKeySelective(ChangeHistory history) {
		return changeHistoryMapper.updateByPrimaryKeySelective(history);
	}
	
	
}
