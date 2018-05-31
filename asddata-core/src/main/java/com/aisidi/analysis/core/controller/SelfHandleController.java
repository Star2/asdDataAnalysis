package com.aisidi.analysis.core.controller;

import com.aisidi.analysis.core.mapper.resultDataMapper;
import com.aisidi.analysis.core.model.ChangeHistory;
import com.aisidi.analysis.core.model.ResultData;
import com.aisidi.analysis.core.model.SelfHandle;
import com.aisidi.analysis.core.service.ChangeHistoryService;
import com.aisidi.analysis.core.service.SelfHandleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhaojy
 * @date 2018/5/24
 */
@Controller
@RequestMapping(value = "/selfHandle")
public class SelfHandleController {

    @Autowired
    private SelfHandleService selfHandleService;

    @Autowired
    private ChangeHistoryService changeHistoryService;

    @Autowired
    private resultDataMapper resultDataMapper;

    @ResponseBody
    @PostMapping("/add")
    public int addSelfHandle(SelfHandle selfHandle){
        return selfHandleService.insert(selfHandle);
    }

    @ResponseBody
    @PostMapping("/select")
    public PageInfo selectSelfHandlePage(){
        return selfHandleService.findItemByPage(1,2);
    }

    @ResponseBody
    @PostMapping("/selectSelf")
    public List<ResultData> selectSelf(){
        List<ResultData> list = changeHistoryService.selectSelfChange();
//        resultDataMapper.insertByBatch(list);
        return list;
//        return changeHistoryService.selectSelfChange();
    }

}
