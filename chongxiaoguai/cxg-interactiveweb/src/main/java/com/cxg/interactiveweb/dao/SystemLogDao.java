package com.cxg.interactiveweb.dao;

import com.cxg.common.mapper.IGeneralDaoMybatis;
import com.cxg.entity.SystemLogBean;
/**
 * @ClassName: ICityInfoDao
* @Description: 城市信息
* @author tanghuan
* @date 2017年2月13日
 */
public interface SystemLogDao extends IGeneralDaoMybatis<SystemLogBean> {


	void saveSystemLog(SystemLogBean record);

}
