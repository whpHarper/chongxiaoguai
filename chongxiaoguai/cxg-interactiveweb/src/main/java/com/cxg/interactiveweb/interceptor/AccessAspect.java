package com.cxg.interactiveweb.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*import com.cxg.interactiveweb.common.service.CompanyAccessRoleService;*/

/**
 * 事件日志 切面,凡是带有 @ValidatePermission 控制器 都要进行 功能权限检查，
 * 若无权限，则抛出AccessDeniedException 异常，该异常将请求转发至一个控制器，然后将异常结果返回
 * @author zhangpeng
 * @date 2017年4月7日
 */
public class AccessAspect {
	private final static Logger LOGGER = LoggerFactory.getLogger (AccessAspect.class);
	@Autowired
	/*private CompanyAccessRoleService companyAccessRoleService;
	
	public void doBefore(JoinPoint jp) throws IOException{
		LOGGER.info("log AccessAspect Before method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
        Method soruceMethod = getSourceMethod(jp);
        if(soruceMethod!=null){
            ValidatePermission oper = soruceMethod.getAnnotation(ValidatePermission.class);
            if (oper != null) {
            	//获取方法第一个参数(权限标识)
                String flag = oper.flag();//权限标识
                //获取session信息
                HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session =request.getSession(); 
                boolean status = companyAccessRoleService.checkAccess(flag,session);
                if(status){
                	return ;//正常
                }else{
                	throw new AccessDeniedException("无权操作该功能!");
                }
            }
        }
    }*/
	
    private Method getSourceMethod(JoinPoint jp){
        Method proxyMethod = ((MethodSignature) jp.getSignature()).getMethod();
        try {
            return jp.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
