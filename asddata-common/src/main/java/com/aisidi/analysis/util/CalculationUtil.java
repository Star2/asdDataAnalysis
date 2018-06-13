package com.aisidi.analysis.util;

import java.math.BigDecimal;

public class CalculationUtil {

	public static boolean bigThan(BigDecimal str ,BigDecimal decimal) {
		int flag = str.compareTo(decimal);
		if(flag == -1) {
			return false ;
		}
		return true ;
	}
	
	public static BigDecimal avg(BigDecimal now ,BigDecimal last) {
		return now.add(last).divide(AnalysisConstant.TWO);
	}
	
	/**
	 * avg(now+last) > limitHigh
	 * @param now
	 * @param last
	 * @param limitHigh
	 * @return
	 */
	public static boolean avgCheck(BigDecimal now ,BigDecimal last ,BigDecimal limitHigh) {
		BigDecimal avg = avg(now, last);
		int flag = avg.compareTo(limitHigh);
		if(flag == -1) {
			return false;
		}
		return true ;
	}
	
	public static boolean sum(BigDecimal now ,BigDecimal last , BigDecimal blast ,BigDecimal bi) {
		int flag = now.compareTo((last.add(blast)).multiply(bi));
		if(flag == -1) {
			return false ;
		}
		return true ;
	}
	
	public static boolean maxCheck(BigDecimal now ,BigDecimal last , BigDecimal blast ,BigDecimal bi) {
		if(bi.compareTo(now) ==1 || bi.compareTo(last) ==1 || bi.compareTo(blast) == 1) {
			return true ;
		}
		return false ;
	}
	
	public static BigDecimal deleteMaxAvg(BigDecimal now ,BigDecimal last , BigDecimal blast) {
		if(now.compareTo(last) == 1 ) {
			if(now.compareTo(blast) == 1) {
                //当前月最大
				return last.add(blast).divide(AnalysisConstant.TWO);
			}else {
                //上上个月最大
				return now.add(last).divide(AnalysisConstant.TWO) ;
			}
		}else {
			if(last.compareTo(blast) == 1) {
			    //上个月最大
				return blast.add(now).divide(AnalysisConstant.TWO) ;
			}else {
                //上上个月最大
				return now.add(last).divide(AnalysisConstant.TWO) ;
			}
		}
	}
}
