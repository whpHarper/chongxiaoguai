package com.cxg.interactiveweb.login.service.impl;

import org.springframework.stereotype.Service;

import com.cxg.entity.LoginBean;
import com.cxg.interactiveweb.login.service.LoginService;
import com.cxg.service.impl.GeneralServiceImpl;

@Service("LoginService")
public class LoginServiceImpl extends GeneralServiceImpl<LoginBean> implements LoginService {
	
}
