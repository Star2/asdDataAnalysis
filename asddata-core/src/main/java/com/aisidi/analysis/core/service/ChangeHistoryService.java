package com.aisidi.analysis.core.service;

import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;

import java.util.List;

/**
 * @author zhaojy
 * @date 2018/5/30
 */
public interface ChangeHistoryService {

    List<ResultData> selectSelfChange();
}
