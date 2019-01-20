package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.FunctionDao;
import com.jzsk.filecode.model.entity.TrFunction;
import com.jzsk.filecode.service.FunctionService;


@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionDao functionDao;
	
	@Override
	public int deleteByPrimaryKey(String functionId) {
		// TODO Auto-generated method stub
		return functionDao.deleteByPrimaryKey(functionId);
	}

	@Override
	public int insert(TrFunction record) {
		// TODO Auto-generated method stub
		return functionDao.insert(record);
	}

	@Override
	public int insertSelective(TrFunction record) {
		// TODO Auto-generated method stub
		return functionDao.insertSelective(record);
	}

	@Override
	public TrFunction selectByPrimaryKey(String functionId) {
		// TODO Auto-generated method stub
		return functionDao.selectByPrimaryKey(functionId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrFunction record) {
		// TODO Auto-generated method stub
		return functionDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrFunction record) {
		// TODO Auto-generated method stub
		return functionDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrFunction> selectAllFunction() {
		// TODO Auto-generated method stub
		return functionDao.selectAllFunction();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return functionDao.countAll();
	}

}
