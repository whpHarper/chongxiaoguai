package com.cxg.interactiveweb.logs.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cxg.entity.CustUserBean;
import com.cxg.interactiveweb.logs.service.SystemLogService;
import com.cxg.interactiveweb.tools.UserUtils;

/**
 * 自定义注解 拦截service
 */
@Component
public class LogInterceptor {
	@Resource
	private SystemLogService systemLogService;
	private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	/**
	 * @Description: 前置通知
	 * @param @param joinPoint
	 * @return void
	 * @author liulin
	 */
	public void before(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		CustUserBean user = UserUtils.getUserBySession(session);
		if (user == null) {
			user = new CustUserBean();
			user.setName("非注册用户");
		}
		String methodName = joinPoint.getSignature().getName();
		try {
			logger.info("=====Entering   " + methodName + "()=====");
			logger.info("请求方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			logger.info("请求人:" + user.getName());
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==Entering   " + methodName + "()异常==");
			logger.error("异常信息:{}", e.getMessage());
		}

	}

	/**
	 * @Description: 后置通知
	 * @param @param joinPoint
	 * @return void
	 * @author liulin
	 */
	public void after(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		CustUserBean user = UserUtils.getUserBySession(session);
		if (user == null) {
			user = new CustUserBean();
			user.setName("非注册用户");
		}
		// 请求的IP
		String methodName = joinPoint.getSignature().getName();
		try {
			logger.info("=====leaving   " + methodName + "()=====");
			// contentToTxt("=====leaving   " + methodName + "()=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==leaving   " + methodName + "()异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}

	/**
	 * @Description: 通用异常通知
	 * @param @param joinPoint
	 * @param @param e
	 * @param @throws NoSuchFieldException
	 * @param @throws SecurityException
	 * @return void
	 * @author liulin
	 */
	public void afterThrowing(JoinPoint joinPoint, Throwable e)
			throws NoSuchFieldException, SecurityException {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		CustUserBean user = UserUtils.getUserBySession(session);
		if (user == null) {
			user = new CustUserBean();
			user.setName("非注册用户");
		}
		// 请求的IP
		String params = "";
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			for (Object obj : args) {
				if (null != obj) {
					Field[] fields = obj.getClass().getDeclaredFields();
					if (null != fields && fields.length > 0) {
						params += obj.getClass().getSimpleName() + "[";
						for (Field field : fields) {
							String name = field.getName();
							Object value = getFieldValueByName(name, obj);
							if (null != value && (!"".equals(value))) {
								params += name + ":" + value + ";";
							}
						}
						params += "],";
					} else {
						params += obj.getClass().getSimpleName() + ":"
								+ obj.toString() + ";";
					}
				}
			}

		}
		String methodName = joinPoint.getSignature().getName();
		try {
			/* ========控制台输出========= */
			logger.info("=====Entering   " + methodName + "()异常=====");
			logger.info("异常代码:" + e.getClass().getName());
			logger.info("异常信息:" + e.getMessage());
			logger.info("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			logger.info("请求人:" + user.getName());
			logger.info("请求参数:" + params);
			// ==========数据库日志=========
			logger.info("=====leaving   " + methodName + "()异常=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==" + methodName + "()异常通知异常==");
			logger.error("异常信息:{}", ex.getMessage());
			logger.error("==" + methodName + "()异常结束==");
		}
		// ==========记录本地异常日志==========
		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget()
				.getClass().getName()
				+ joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);

	}

	/**
	 * @Description: 根据属性名获取属性值
	 * @param @param fieldName
	 * @param @param o
	 * @param @return
	 * @return Object
	 * @author liulin
	 */
	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			if (o.getClass().getName().startsWith("com.cxg")) {
				Method method = o.getClass().getMethod(getter, new Class[] {});
				Object value = method.invoke(o, new Object[] {});
				return value;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}


}