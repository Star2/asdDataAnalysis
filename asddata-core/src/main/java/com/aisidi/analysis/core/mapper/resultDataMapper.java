package com.aisidi.analysis.core.mapper;

import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;

import java.util.List;

public interface resultDataMapper {

    int insert(ResultData record);

    int insertByBatch(List<ResultData> list);

}