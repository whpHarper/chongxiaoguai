package com.cxg.interactiveweb.tools;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Encoder;

/**
 * @Description: 加密公共类
 * @author haipeng
 * @date 2017年5月8日
 */
public class EncryptionUtils {
	/**
	 * @Description: 使用md5加密
	 * @param @param request
	 * @param @return   
	 * @return String 
	 * @author haipeng
	 */
	public static String encryption(HttpServletRequest request){
		String ip=IpUtil.getIpAddress(request);
		String sysRandomNum=new StringBuilder(ip+request.getSession().getId()).reverse().toString();
		MessageDigest md5;
		try {
			md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en=new BASE64Encoder();
			sysRandomNum=base64en.encode(md5.digest(sysRandomNum.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysRandomNum;
	}
}
