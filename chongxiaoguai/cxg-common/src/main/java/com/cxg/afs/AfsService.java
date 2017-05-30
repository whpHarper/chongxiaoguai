package com.cxg.afs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.jaq.model.v20161123.AfsCheckRequest;
import com.aliyuncs.jaq.model.v20161123.AfsCheckResponse;
import com.aliyuncs.jaq.model.v20161123.SpamRegisterPreventionRequest;
import com.aliyuncs.jaq.model.v20161123.SpamRegisterPreventionResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.cxg.sms.AliyunSendMessageService;
import com.cxg.utils.ConfigProperties;

@Service
public class AfsService {
 private static Log logger = LogFactory.getLog(AfsService.class);
	 
	 private  IClientProfile profile;
	 private  IAcsClient client;
	 public AfsService(){
		ConfigProperties configProperties = new ConfigProperties();
		 this.profile= DefaultProfile.getProfile("cn-hangzhou", configProperties.getProperty("aliyun_accesskey"),configProperties.getProperty("aliyun_secret"));
		 this.client = new DefaultAcsClient(profile);
        try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "jaq", "jaq.aliyuncs.com");
		} catch (ClientException e) {
			e.printStackTrace();
		}
	 }
	 
	 
	 public Boolean afsInterception(AfsParams afsParams){
		Boolean result = true;
		AfsCheckRequest request = new AfsCheckRequest();
        request.setPlatform(3);//必填参数，请求来源： 1：Android端； 2：iOS端； 3：PC端及其他
        request.setSession(afsParams.getSession());// 必填参数，从前端获取，不可更改
        request.setSig(afsParams.getSig());// 必填参数，从前端获取，不可更改
        request.setToken(afsParams.getToken());// 必填参数，从前端获取，不可更改
        request.setScene(afsParams.getScene());// 必填参数，从前端获取，不可更改
 
        try {
            AfsCheckResponse response = client.getAcsResponse(request);
            result=response.getData();
        } catch (Exception e) {
            e.printStackTrace();            
        }        
		return result;
	 }
	 
	 /**
	  *风险等级。0：无风险；1：高风险；2：中风险
	 *@author zhangpeng
	 * @param afsToken
	 * @param afsScene
	 * @return
	 *@date 2017年4月18日
	 */
	public int afsPrevention(String afsToken,String mobile,String ip){
		SpamRegisterPreventionRequest request = new SpamRegisterPreventionRequest();
        // 必填参数
        request.setPhoneNumber(mobile);
        request.setIp(ip);
        request.setProtocolVersion("1.0.1");
        request.setSource(1); //注册来源。1：PC网页；2：移动网页；3：APP;4:其它
        request.setJsToken(afsToken); //对应前端页面的afs_token，source来源为1&2&4时，必填;
        int riskRank = 0;//风险级别
        try {
            SpamRegisterPreventionResponse response = client.getAcsResponse(request);
            if(response.getErrorCode()==0){
            	 riskRank=response.getData().getFnalDecision();
            }else{
            	riskRank=3;
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
		return riskRank;
	 }
	 
}
