package com.aisidi.analysis.core.service.impl;

import com.aisidi.analysis.core.mapper.ChangeHistoryMapper;
import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;
import com.aisidi.analysis.core.service.ChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojy
 * @date 2018/5/30
 */
@Service
public class ChangeHistoryServiceImpl implements ChangeHistoryService {

    @Autowired
    ChangeHistoryMapper changeHistoryMapper;
    @Override
    public List<ResultData> selectSelfChange() {
        List list = changeHistoryMapper.selectSelfChange();
        return list;
    }
}
