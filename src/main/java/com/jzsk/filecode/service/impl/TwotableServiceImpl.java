package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.TwotableDao;
import com.jzsk.filecode.model.entity.TrTwotable;

@Service
public class TwotableServiceImpl implements com.jzsk.filecode.service.TwotableService {

	@Autowired
	private TwotableDao twotableDao;

	@Override
	public int deleteByPrimaryKey(String twotableId) {
		// TODO Auto-generated method stub
		return twotableDao.deleteByPrimaryKey(twotableId);
	}

	@Override
	public int insert(TrTwotable record) {
		// TODO Auto-generated method stub
		return twotableDao.insert(record);
	}

	@Override
	public int insertSelective(TrTwotable record) {
		// TODO Auto-generated method stub
		return twotableDao.insertSelective(record);
	}

	@Override
	public TrTwotable selectByPrimaryKey(String twotableId) {
		// TODO Auto-generated method stub
		return twotableDao.selectByPrimaryKey(twotableId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrTwotable record) {
		// TODO Auto-generated method stub
		return twotableDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrTwotable record) {
		// TODO Auto-generated method stub
		return twotableDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrTwotable> selectAllTwotable() {
		// TODO Auto-generated method stub
		return twotableDao.selectAllTwotable();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return twotableDao.countAll();
	}

	@Override
	public int selectMaxByTwoId(String twoId) {
		// TODO Auto-generated method stub
		Integer max = twotableDao.selectMaxByTwoId(twoId);
		if (max == null) {
			max = 001;
		}
		return max;
	}

}
