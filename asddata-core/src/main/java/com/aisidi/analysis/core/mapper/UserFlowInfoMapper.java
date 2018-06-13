package com.aisidi.analysis.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aisidi.analysis.core.model.UserFlowInfo;
import com.aisidi.analysis.core.model.UserFlowInfoKey;
import com.aisidi.analysis.core.model.dto.UserFlowDTO;

public interface UserFlowInfoMapper {
    int deleteByPrimaryKey(UserFlowInfoKey key);

    int insert(UserFlowInfo record);

    int insertSelective(UserFlowInfo record);

    UserFlowInfo selectByPrimaryKey(UserFlowInfoKey key);

    int updateByPrimaryKeySelective(UserFlowInfo record);

    int updateByPrimaryKey(UserFlowInfo record);
    
    List<UserFlowDTO> queryUserFlow(@Param("month")Integer mouth, 
						    		@Param("lastMonth")Integer lastMonth, 
						    		@Param("llastMonth")Integer llastMonth , 
						    		@Param("startPage")long startPage  , 
						    		@Param("endPage")long endPage );

	int queryUserFlowCount(@Param("month")Integer month, 
							@Param("lastMonth")Integer lastMonth, 
							@Param("llastMonth")Integer llastMonth);
}