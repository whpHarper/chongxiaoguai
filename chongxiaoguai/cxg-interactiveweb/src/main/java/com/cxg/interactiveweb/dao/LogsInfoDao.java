package com.cxg.interactiveweb.dao;

import com.cxg.common.mapper.IGeneralDaoMybatis;
import com.cxg.entity.LogsInfoBean;
/**
 * @ClassName: LogsInfoDao
* @Description: 日志表
* @author tanghuan
* @date 2017年2月13日
 */
public interface LogsInfoDao extends IGeneralDaoMybatis<LogsInfoBean>{

	public void insertLogsInfo(LogsInfoBean logsInfoBean);

}
