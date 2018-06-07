package com.aisidi.analysis.core.utils;

/**
 * 计算变更套餐的盈利
 * @author zhaojy
 * @date 2018/6/7
 */
public class ProfitUtils {

    /**
     * 计算变更套餐产生的盈利
     *
     * @param useFlow 流量使用量
     * @param oldPFlow 用户套餐流量
     * @param oldPPrice 用户套餐流量价
     * @param changePFlow 变更套餐流量
     * @param changePPrice 变更套餐价
     * @return 盈利金额
     */
    public static double calculateProfit(String useFlow, String oldPFlow, String oldPPrice, String changePFlow, String changePPrice){
        //按照用户购买的套餐，计算费用
        double oldFlowCast = Double.parseDouble(oldPPrice);
        //按照变更后的套餐，计算费用
        double changeFlowCast = Double.parseDouble(changePPrice);
        //变更创造的盈利
        double profit;
        double difference1 = Double.parseDouble(useFlow)-Double.parseDouble(oldPFlow);
        if(difference1>0){
            //如果使用流量超过套餐内流量，超过部分以0.29/M计算
            oldFlowCast += difference1 * CoreConstant.unitPrice;
        }
        double difference2 = Double.parseDouble(useFlow)-Double.parseDouble(changePFlow);
        if(difference2>0){
            changeFlowCast += difference2 * CoreConstant.unitPrice;
        }
        //变更创造的盈利 -值为亏损。+值为盈利
        profit = oldFlowCast - changeFlowCast;
        return profit;
    }
}
