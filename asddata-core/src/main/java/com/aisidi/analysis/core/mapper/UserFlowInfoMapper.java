package com.aisidi.analysis.core.mapper;

import com.aisidi.analysis.core.model.UserFlowInfo;
import com.aisidi.analysis.core.model.UserFlowInfoKey;

public interface UserFlowInfoMapper {
    int deleteByPrimaryKey(UserFlowInfoKey key);

    int insert(UserFlowInfo record);

    int insertSelective(UserFlowInfo record);

    UserFlowInfo selectByPrimaryKey(UserFlowInfoKey key);

    int updateByPrimaryKeySelective(UserFlowInfo record);

    int updateByPrimaryKey(UserFlowInfo record);
}