package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.ThreetableDao;
import com.jzsk.filecode.model.entity.TrThreetable;
import com.jzsk.filecode.service.ThreetableService;
@Service
public class ThreetableServiceImpl implements ThreetableService {

	@Autowired
	private ThreetableDao threetableDao;
	
	@Override
	public int deleteByPrimaryKey(String threetableId) {
		// TODO Auto-generated method stub
		return threetableDao.deleteByPrimaryKey(threetableId);
	}

	@Override
	public int insert(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.insert(record);
	}

	@Override
	public int insertSelective(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.insertSelective(record);
	}

	@Override
	public TrThreetable selectByPrimaryKey(String threetableId) {
		// TODO Auto-generated method stub
		return threetableDao.selectByPrimaryKey(threetableId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrThreetable> selectAllThreetable() {
		// TODO Auto-generated method stub
		return threetableDao.selectAllThreetable();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return threetableDao.countAll();
	}

	@Override
	public int selectMaxByThreeNum(String threeNum) {
		// TODO Auto-generated method stub
		return threetableDao.selectMaxByThreeNum(threeNum);
	}

	@Override
	public int selectMaxByDepartment(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.selectMaxByDepartment(record);
	}

	@Override
	public List<TrThreetable> selectMaxByThreeIdAndDepartmentAndTableName(TrThreetable record) {
		// TODO Auto-generated method stub
		return threetableDao.selectMaxByThreeIdAndDepartmentAndTableName(record);
	}

}
