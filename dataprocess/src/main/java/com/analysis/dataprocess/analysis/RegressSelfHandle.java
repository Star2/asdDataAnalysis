package com.analysis.dataprocess.analysis;

import com.aisidi.analysis.core.mapper.resultDataMapper;
import com.aisidi.analysis.core.model.ResultData;
import com.aisidi.analysis.core.service.ChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 自主办理回调数据
 * 根据自主办理表和历史变更表 生成自主办理回调表
 * @author zhaojy
 * @date 2018/5/29
 */
public class RegressSelfHandle {


    @Autowired
    private ChangeHistoryService changeHistoryService;
    @Autowired
    private resultDataMapper resultDataMapper;

    /**
     * 处理自主办理数据
     */
    public void selfRegress(){
        //在历史变更表查询出所有自定义变更数据
        List<ResultData> list = changeHistoryService.selectSelfChange();
        //将查出的数据作为回调数据保存到结果表
        resultDataMapper.insertByBatch(list);
    }
}
