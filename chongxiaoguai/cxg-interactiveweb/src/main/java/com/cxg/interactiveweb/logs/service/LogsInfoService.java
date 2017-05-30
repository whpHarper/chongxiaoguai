package com.cxg.interactiveweb.logs.service;

import com.cxg.entity.LogsInfoBean;
import com.cxg.service.IGeneralService;
/**
 * @ClassName: LogsInfoService
* @Description: 日志管理
* @author tanghuan
* @date 2017年2月13日
 */
public interface LogsInfoService extends IGeneralService<LogsInfoBean> {

	public void insertLogsInfo(LogsInfoBean logsInfoBean);

}
