package com.cxg.interactiveweb.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*import com.cxg.entity.CustUserBean;
import com.cxg.interactiveweb.tools.Constants;
import com.cxg.interactiveweb.tools.UserUtils;*/

/**
 * 
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截器
 * @author zhanghao
 * @date 2017年2月16日 上午9:34:56
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * Handler执行完成之后调用这个方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav) throws Exception {

	}

	/**
	 * Handler执行之前调用这个方法
	 */

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
	/*	response.setHeader("Access-Control-Allow-Origin", "*");
		String url = request.getRequestURI();
		// URL:login.html是公开的;这个demo是除了tologin.html是可以公开访问的，其它的URL都进行拦截控制
		if (url.indexOf("login.html") >= 0) {
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		CustUserBean custUserBean = new CustUserBean();
		custUserBean=UserUtils.getUserBySession(session);
		if (custUserBean != null) {
			return true;
		}else{
			if(request.getHeader("X-Requested-With") !=null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")){
				PrintWriter out = response.getWriter();  
	            out.print("loseSession");//session失效
	            out.flush();
	            return false;
			}
			if(request.getHeader("X-Requested-With") !=null && request.getHeader("X-Requested-With").equalsIgnoreCase("io.dcloud.HBuilder")){
				PrintWriter out = response.getWriter();  
				out.print("loseSession");//session失效
				out.flush();
				return false;
			}
		}
		// 不符合条件的，跳转到登录界面
		request.getRequestDispatcher("/UserLogin/tologin.html").forward(
				request, response);*/

		return false;
	}

}
