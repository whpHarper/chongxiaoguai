package com.cxg.interactiveweb.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxg.entity.LoginBean;
import com.cxg.interactiveweb.login.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/toLogin")
	public String toCompanyCity(){
		return "index";
	}
	
	@RequestMapping(value="/getLoginInfo",method=RequestMethod.GET)
	/*@ResponseBody*/
	public String getLoginInfo(){
		Long id=1L;
		List<LoginBean> loginBeanList=loginService.selectAll();
		System.out.println(loginBeanList.get(0).toString());
		return loginBeanList.get(0).toString();
	}
}