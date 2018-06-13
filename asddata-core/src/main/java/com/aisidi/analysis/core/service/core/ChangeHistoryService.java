package com.aisidi.analysis.core.service.core;

import java.util.List;

import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;

/**
 * @author zhaojy
 * @date 2018/5/30
 */
public interface ChangeHistoryService {

    List<ResultData> selectSelfChange();
    
    ChangeHistory queryByPhoneDesc(String phone);
    
    int insert(ChangeHistory history);
    
    int updateByPrimaryKeySelective(ChangeHistory history);
}
