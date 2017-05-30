package com.cxg.interactiveweb.logs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxg.entity.LogsInfoBean;
import com.cxg.interactiveweb.dao.LogsInfoDao;
import com.cxg.interactiveweb.logs.service.LogsInfoService;
import com.cxg.service.impl.GeneralServiceImpl;

/**
 * @ClassName: LogsInfoServiceImpl
* @Description: 日志管理
* @author tanghuan
* @date 2017年2月13日
 */
@Service("logsInfoService")
public class LogsInfoServiceImpl extends GeneralServiceImpl<LogsInfoBean> implements
		LogsInfoService {
	@Autowired
	private LogsInfoDao logsInfoDao;
	@Override
	public void insertLogsInfo(LogsInfoBean logsInfoBean) {
		logsInfoDao.insertLogsInfo(logsInfoBean);
	}

	

}
