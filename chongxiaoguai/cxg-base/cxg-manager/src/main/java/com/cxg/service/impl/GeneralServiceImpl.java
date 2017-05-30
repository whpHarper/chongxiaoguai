package com.cxg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import com.cxg.common.mapper.IGeneralDaoMybatis;
import com.cxg.service.IGeneralService;

public class GeneralServiceImpl<T> implements IGeneralService<T> {
	@Autowired
	private IGeneralDaoMybatis<T> mapper;

//	@Autowired
//	private IGeneralDaoMybatis<T> mySqlMapper;

//	@Autowired
//	private ConditionMapper<T> conditionMapper;

	public IGeneralDaoMybatis<T> getMapper() {
		return mapper;
	}
	

	

	public List<T> selectAll() {
		return mapper.selectAll();
	}

	public List<T> select(T record) {
		return mapper.select(record);
	}

	public T selectByPrimaryKey(Object key) {

		return mapper.selectByPrimaryKey(key);
	}

	public int selectCount(T record) {

		return mapper.selectCount(record);
	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	public int insert(T record) {

		return mapper.insert(record);
	}

	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}

	public int insertList(List<T> recordList) {
		return mapper.insertList(recordList);
	}

	public int insertUseGeneratedKeys(T record) {
		return mapper.insertUseGeneratedKeys(record);
	}

	public int updateByPrimaryKey(T record) {

		return mapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(T record) {

		return mapper.updateByPrimaryKeySelective(record);
	}

//	public int updateByCondition(T record, Object condition) {
//
//		return conditionMapper.updateByCondition(record, condition);
//	}
//
//	public int updateByConditionSelective(T record, Object condition) {
//
//		return conditionMapper.updateByConditionSelective(record, condition);
//	}

	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	public int delete(T record) {

		return mapper.delete(record);
	}

	public T selectOne(T record) {

		return mapper.selectOne(record);
	}

	

}
