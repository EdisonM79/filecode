package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.FilenameDao;
import com.jzsk.filecode.model.entity.TrFilename;
import com.jzsk.filecode.service.FilenameService;
@Service
public class FilenameServiceImpl implements FilenameService {

	@Autowired
	private FilenameDao filenameDao;
	
	@Override
	public int deleteByPrimaryKey(String filenameId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TrFilename record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TrFilename record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TrFilename selectByPrimaryKey(String filenameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TrFilename record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TrFilename record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TrFilename> selectAllFilecode() {
		// TODO Auto-generated method stub
		return filenameDao.selectAllFilecode();
	}

}
