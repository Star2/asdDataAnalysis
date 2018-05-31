package com.aisidi.analysis.core.mapper;

import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;

import java.util.List;

public interface ChangeHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChangeHistory record);

    int insertSelective(ChangeHistory record);

    ChangeHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChangeHistory record);

    int updateByPrimaryKey(ChangeHistory record);

    List<ResultData> selectSelfChange();
}