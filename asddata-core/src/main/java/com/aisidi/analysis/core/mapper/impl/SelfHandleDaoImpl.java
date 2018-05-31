package com.aisidi.analysis.core.mapper.impl;

import com.aisidi.analysis.core.mapper.SelfHandleMapper;
import com.aisidi.analysis.core.model.SelfHandle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 处理自变更数据
 * 与历史变更数据匹配，将变更过历史数据恢复到用户自变更的套餐
 * 获取到变过再次变更数据
 * @author zhaojy
 * @date 2018/5/28
 */
public abstract class SelfHandleDaoImpl implements SelfHandleMapper {
    @Autowired
    private SelfHandleMapper docMapper;

    public List<SelfHandle> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        return null;
    }
}
