package com.cxg.sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.cxg.utils.ConfigProperties;

/**
 * 阿里云短信发送实现
 * @author haipeng
 * 
 */
@Service
public class AliyunSendMessageService {
	 private static Log logger = LogFactory.getLog(AliyunSendMessageService.class);
	 
	 private  IClientProfile profile;
	 private  IAcsClient client;
	 private String sign;//管理控制台中配置的短信签名（状态必须是验证通过）
	 
	 public AliyunSendMessageService() {
		ConfigProperties configProperties = new ConfigProperties();
		this.sign=configProperties.getProperty("aliyun_message_sign");
		this.profile = DefaultProfile.getProfile("cn-hangzhou", configProperties.getProperty("aliyun_accesskey"),configProperties.getProperty("aliyun_secret"));
	    try {
			DefaultProfile.addEndpoint("cn-hangzhou","cn-hangzhou","Sms","sms.aliyuncs.com");
		} catch (ClientException e) {
			e.printStackTrace();
		}
	    this.client = new DefaultAcsClient(profile);
	}
	 
	/**
	 * @param templateCode 管理控制台中配置的审核通过的短信模板的模板CODE（状态必须是验证通过）
	 * @param paramString 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。 例如:短信模板为：“接受短信验证码${no}”,此参数传递{“no”:”123456”}，用户将接收到[短信签名]接受短信验证码123456
	 * @param recNum 目标手机号，多个手机号可以逗号分隔
	 */
	public String sendMessage(String templateCode,String paramString,String recNum){
		SingleSendSmsRequest request = new SingleSendSmsRequest();
		String success="false";//发送状态//TODO 记得开启状态
		/*try {
	        request.setSignName(sign);
	        request.setTemplateCode(templateCode);
	        request.setParamString(paramString);
	        request.setRecNum(recNum);
	        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
	        logger.info("recNum:"+recNum+" requestId:"+httpResponse.getRequestId()+" model:"+httpResponse.getModel());
	       if(!StringUtils.isEmpty(httpResponse.getRequestId())&&!StringUtils.isEmpty(httpResponse.getModel())){
	        	success="true";
	        	return success;
	        }else{
	        	return success;
	        }
	    } catch (ServerException e) {
	    	logger.info("recNum:"+recNum+"==>sendMessageError");
	        e.printStackTrace();
	    }
	    catch (ClientException e) {
	    	logger.info("recNum:"+recNum+"==>sendMessageError");
	        e.printStackTrace();
	    }*/
		success="true";
	    return success;
		
	}
	 
	
}
