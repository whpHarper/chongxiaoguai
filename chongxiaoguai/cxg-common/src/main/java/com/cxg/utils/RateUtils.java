package com.cxg.utils;

import java.math.BigDecimal;

public class RateUtils {
	/**
	 * 年化利率转折扣率 四舍五入
	 * @param yearRate 年化率%
	 * @param day 剩余天数
	 * @return 折扣率%
	 * @author qiaohfeng 2017年3月13日 18:45:27
	 */
	public static BigDecimal YearRateToDiscount(BigDecimal yearRate,Integer day){
		//折扣率 = 年利率*帐款剩余天数/360
		return yearRate.multiply(new BigDecimal(day)).divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 折扣率转年化利率 四舍五入
	 * @param discount 折扣率%
	 * @param day 剩余天数
	 * @return 年化率%
	 * @author qiaohfeng 2017年3月13日 18:45:27
	 */
	public static BigDecimal DiscountToYearRate(BigDecimal discount,Integer day){
		//年利率 = 折扣率/帐款剩余天数*360
		return discount.multiply(new BigDecimal(360)).divide(new BigDecimal(day),2,BigDecimal.ROUND_HALF_UP);
	}
	
}