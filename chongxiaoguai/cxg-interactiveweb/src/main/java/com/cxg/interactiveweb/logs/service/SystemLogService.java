package com.cxg.interactiveweb.logs.service;

import com.cxg.entity.SystemLogBean;
import com.cxg.service.IGeneralService;

/**
 * @ClassName: LogService
 * @Description: 日志管理
 * @author liulin
 * @date 2017年4月10日
 */
public interface SystemLogService extends IGeneralService<SystemLogBean> {

//	int deleteSystemLog(String id);

	void saveSystemLog(SystemLogBean record);


//	int saveTest(SystemLog record);
//
//	SystemLog selectSystemLog(String id);
//
//	int updateSystemLog(SystemLog record);

}