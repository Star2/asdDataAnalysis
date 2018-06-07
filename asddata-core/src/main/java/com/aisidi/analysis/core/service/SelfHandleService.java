package com.aisidi.analysis.core.service;

import com.aisidi.analysis.core.model.SelfHandle;
import com.github.pagehelper.PageInfo;

/**
 * @author zhaojy
 * @date 2018/5/24
 */

public interface SelfHandleService {
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(SelfHandle record);

    /**
     * 分页查询
     * @param currentPage
     * @param pageNum
     * @return
     */
    PageInfo<SelfHandle> findItemByPage(int currentPage, int pageNum);

    /**
     * 查询数量
     * @return 数量
     */
    public int selectCount();
}
