package com.cxg.email;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.cxg.utils.ConfigProperties;

public class AliyunEmailService {
	/**
	 * 阿里云邮箱推送-qiaohfeng 2017年2月8日 16:07:12
	 * @param toAddress 收信人地址
	 * @param title   邮件标题
	 * @param content  正文     
	 */	
		
	public static void sendEmail(String toAddress,String title,String content) {   
		Properties p=new Properties();
		try {
			ConfigProperties congfig = new ConfigProperties("/sendEmail.properties");
	        IClientProfile profile = DefaultProfile.getProfile(congfig.getProperty("city"), congfig.getProperty("key"), congfig.getProperty("secretkey"));
	        IAcsClient client = new DefaultAcsClient(profile);
	        SingleSendMailRequest request = new SingleSendMailRequest();
            request.setAccountName(congfig.getProperty("accountName"));
            request.setAddressType(Integer.parseInt(congfig.getProperty("addressType")));
            request.setTagName(congfig.getProperty("tagName"));
            request.setReplyToAddress(Boolean.getBoolean(congfig.getProperty("replyToAddress")));
            request.setToAddress(toAddress);
            request.setSubject(title);
            request.setHtmlBody(content);
            request.setFromAlias(congfig.getProperty("fromAlias"));
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		System.out.println("发送邮件开始...");
		AliyunEmailService.sendEmail("qiaohfeng@126.com", "title", "content");
		System.out.println("发送邮件结束...");
	}
}
