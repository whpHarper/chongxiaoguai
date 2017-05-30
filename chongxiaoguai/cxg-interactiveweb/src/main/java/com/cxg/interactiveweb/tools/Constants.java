package com.cxg.interactiveweb.tools;

public class Constants {
	/** 手机验证码*/
	public static final String MOBILE_RAND = "MOBILE_RAND";
	
	/** 用户session会话*/
	public static final String CUSTUSER = "CUSTUSER";
	
	/**找回密码时把手机号放进session*/
	public static final String MOBILE_RETRIEVEPWD = "MOBILE_RETRIEVEPWD";
	
	public static final String LASTCOMPANYBY="LASTCOMPANYBY";
	/** 买方 **/
	public static final String BUYER="buyer";
	/** 卖方 **/
	public static final String SUPPLIER="supplier";
	
	public static final String AFSTOKEN="AFSTOKEN";
	//应收待参与
	public static final String L_R_TOPARTICIPATE="LiquidationReceivableToParticipate";
	//应收已参与
	public static final String L_R_HASPARTICIPATED="LiquidationReceivableHasParticipated";
	//应收报价中
	public static final String L_R_OFFER="LiquidationReceivableOffer";
	//应收待收款
	public static final String L_R_TORECEIVE="LiquidationReceivableToReceive";
	//已收待收款
	public static final String L_R_HASRECEIVED="LiquidationReceivableHasReceived";
	//已过期待收款
	public static final String L_R_EXPIRED="LiquidationReceivableExpired";
	//应付待参与
	public static final String L_P_TOPARTICIPATE="LiquidationPayableToParticipate";
	//应付已参与
	public static final String L_P_HASPARTICIPATED="LiquidationPayableHasParticipated";
	//应付报价中
	public static final String L_P_OFFER="LiquidationPayableOffer";
	//应付待付款
	public static final String L_P_TOPAY="LiquidationPayableToPay";
	//已付待付款
	public static final String L_P_HASPAYED="LiquidationPayableHasPayed";
	//已过期待付款
	public static final String L_P_EXPIRED="LiquidationPayableExpired";
}
