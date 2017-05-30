package com.cxg.interactiveweb.tools;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import com.cxg.entity.CustUserBean;

/**
 * session中获取用户
 * @author zhangpeng
 *
 */
public class UserUtils {
	/**
	 * 从session取userID
	 * @param session
	 * @return
	 */
	public static Long getUserIdBySession(HttpSession session) {
		CustUserBean user = (CustUserBean) session.getAttribute(Constants.CUSTUSER);
		Long userId = new Long(0);
		if(user != null){
			userId = user.getId();
			return userId;
		}
		return null;
	}
	
	/**
	 * 从session取userID
	 * @param session
	 * @return
	 */
	public static CustUserBean getUserBySession(HttpSession session) {
		CustUserBean user = (CustUserBean) session.getAttribute(Constants.CUSTUSER);
		if(user != null){
			return user;
		}
		return null;
	}
	
	/**
	 * 获取当前公司id
	 *@author zhangpeng
	 * @param session
	 * @return
	 *@date 2017年3月6日
	 */
	public static Long getCompanyIdBySession(HttpSession session) {
		Long companyId = (Long) session.getAttribute(Constants.LASTCOMPANYBY);
		return companyId;
	}
}
