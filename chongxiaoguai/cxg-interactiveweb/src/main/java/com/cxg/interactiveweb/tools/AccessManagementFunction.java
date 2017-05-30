package com.cxg.interactiveweb.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 按钮角色权限控制器
 * @author haipeng
 * @date 2017年4月6日
 */
public class AccessManagementFunction implements Function{

	@Override
	public Object call(Object[] arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	@Autowired
	private CompanyUserRoleService companyUserRoleService;
	@Autowired
	private CompanyAccessRoleService companyAccessRoleService;
	@Override
	public Object call(Object[] paras, Context ctx) {
		String flag = (String) paras[0];//按钮标识
		HttpServletRequest request = (HttpServletRequest) ctx.getGlobal("request");//获取全局session
		HttpSession session =  request.getSession();
        return companyAccessRoleService.checkAccess(flag, session);
	}*/
}
