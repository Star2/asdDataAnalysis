package com.aisidi.analysis.core.mapper;

import com.aisidi.analysis.core.model.SelfHandle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义变更 表
 * @author zhaojy
 * @date 2018-05-23
 */
public interface SelfHandleMapper {
    /**
     * 删除
     * @param id id
     * @return 结果
     */
    int deleteByPrimaryKey(String id);

    /**
     *  查询
     * @param id
     * @return
     */
    SelfHandle selectByPrimaryKey(String id);

    /**
     *  插入
     * @param record 对象
     * @return 结果
     */
    int insert(SelfHandle record);
    /**
     * 批量插入
     * @param selfHandles 对象s
     */
    void insertByBatch(List<SelfHandle> selfHandles);

    /**
     *  分页查询
     * @param stratRow 开始
     * @param endRow 结束
     * @return 结果
     */
    List<SelfHandle> selectByPage(@Param("stratRow")int stratRow, @Param("endRow")int endRow);

    /**
     * 查询数量
     * @return 数量
     */
    int selectCount();
}