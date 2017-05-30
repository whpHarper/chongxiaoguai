package com.cxg.interactiveweb.logs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxg.entity.LogsInfoBean;
import com.cxg.entity.SystemLogBean;
import com.cxg.interactiveweb.dao.SystemLogDao;
import com.cxg.interactiveweb.logs.service.SystemLogService;
import com.cxg.service.impl.GeneralServiceImpl;



/**
* @Description: 日志管理
* @author liulin
* @date 2017年4月10日
*/
@Service("systemLogService")
public class SystemLogServiceImpl extends GeneralServiceImpl<SystemLogBean>  implements SystemLogService {
	@Resource
	private SystemLogDao systemLogDao;

//	@Override
//	public int deleteSystemLog(String id) {
//
//		return systemLogDao.deleteByPrimaryKey(id);
//	}
//
	@Override
	public void saveSystemLog(SystemLogBean record) {
		 systemLogDao.saveSystemLog(record);
	}
//
//	@Override
//	public SystemLog selectSystemLog(String id) {
//
//		return systemLogDao.selectByPrimaryKey(id);
//	}
//
//	@Override
//	public int updateSystemLog(SystemLog record) {
//
//		return systemLogDao.updateByPrimaryKeySelective(record);
//	}

//	@Override
//	public int saveTest(SystemLogBean record) {
//
//		return systemLogDao.save(record);
//	}


}
