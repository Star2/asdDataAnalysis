package com.aisidi.analysis.core.mapper;

import java.util.List;

import com.aisidi.analysis.core.model.ResultData;

public interface resultDataMapper {

    int insert(ResultData record);

    int insertByBatch(List<ResultData> list);

}