package com.jzsk.filecode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.LogDao;
import com.jzsk.filecode.model.entity.TrLog;
import com.jzsk.filecode.model.entity.TrLogKey;
import com.jzsk.filecode.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;
	@Override
	public int deleteByPrimaryKey(TrLogKey key) {
		// TODO Auto-generated method stub
		return logDao.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TrLog record) {
		// TODO Auto-generated method stub
		return logDao.insert(record);
	}

	@Override
	public int insertSelective(TrLog record) {
		// TODO Auto-generated method stub
		return logDao.insert(record);
	}

	@Override
	public TrLog selectByPrimaryKey(TrLogKey key) {
		// TODO Auto-generated method stub
		return logDao.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(TrLog record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrLog record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKey(record);
	}

}
