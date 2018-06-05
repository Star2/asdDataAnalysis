package com.aisidi.analysis.core.service.core.impl;

import com.aisidi.analysis.core.mapper.SelfHandleMapper;
import com.aisidi.analysis.core.model.SelfHandle;
import com.aisidi.analysis.core.service.core.SelfHandleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * @author zhaojy
 * @date 2018/5/24
 */
@Service
public class SelfHandleServiceImpl implements SelfHandleService {

    @Autowired
    private SelfHandleMapper selfHandleMapper;

    @Override
    public int insert(SelfHandle record) {
        return selfHandleMapper.insert(record);
    }

    @Override
    public PageInfo<SelfHandle> findItemByPage(int currentPage, int pageNum){
        PageInfo<SelfHandle> pageInfo = new PageInfo<>();
        int stratRow = (pageNum-1)*(currentPage-1);
        List<SelfHandle> list = selfHandleMapper.selectByPage(stratRow, pageNum);
        pageInfo.setPrePage(currentPage);
        pageInfo.setPageNum(pageNum);
        pageInfo.setNextPage(currentPage+1);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public int selectCount(){
        return selfHandleMapper.selectCount();
    }
}
