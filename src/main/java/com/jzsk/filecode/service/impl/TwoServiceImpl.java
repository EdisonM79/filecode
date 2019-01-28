package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.TwoDao;
import com.jzsk.filecode.model.entity.TrTwo;
import com.jzsk.filecode.service.TwoService;
@Service
public class TwoServiceImpl implements TwoService {

	@Autowired
	private TwoDao twodao;
	
	@Override
	public int deleteByPrimaryKey(String twoId) {
		// TODO Auto-generated method stub
		return twodao.deleteByPrimaryKey(twoId);
	}

	@Override
	public int insert(TrTwo record) {
		// TODO Auto-generated method stub
		return twodao.insert(record);
	}

	@Override
	public int insertSelective(TrTwo record) {
		// TODO Auto-generated method stub
		return twodao.insertSelective(record);
	}

	@Override
	public TrTwo selectByPrimaryKey(String twoId) {
		// TODO Auto-generated method stub
		return twodao.selectByPrimaryKey(twoId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrTwo record) {
		// TODO Auto-generated method stub
		return twodao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrTwo record) {
		// TODO Auto-generated method stub
		return twodao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrTwo> selectAllTwo() {
		// TODO Auto-generated method stub
		return twodao.selectAllTwo();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return twodao.countAll();
	}

	@Override
	public List<TrTwo> selectAllByFilenameAndDepartmentAndYear(TrTwo trTwo) {
		// TODO Auto-generated method stub
		return twodao.selectAllByFilenameAndDepartmentAndYear(trTwo);
	}

	@Override
	public int selectMaxByYearAndDepartment(TrTwo trTwo) {
		// TODO Auto-generated method stub
		return twodao.selectMaxByYearAndDepartment(trTwo);
	}

	@Override
	public List<TrTwo> selectLatestTwoList() {
		// TODO Auto-generated method stub
		return twodao.selectLatestTwoList();
	}

}
