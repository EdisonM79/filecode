package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.ThreeDao;
import com.jzsk.filecode.model.entity.TrThree;
import com.jzsk.filecode.service.ThreeService;

@Service
public class ThreeServiceImpl implements ThreeService {

	@Autowired
	private ThreeDao threedao;

	@Override
	public int deleteByPrimaryKey(String threeId) {
		// TODO Auto-generated method stub
		return threedao.deleteByPrimaryKey(threeId);
	}

	@Override
	public int insert(TrThree record) {
		// TODO Auto-generated method stub
		return threedao.insert(record);
	}

	@Override
	public int insertSelective(TrThree record) {
		// TODO Auto-generated method stub
		return threedao.insertSelective(record);
	}

	@Override
	public TrThree selectByPrimaryKey(String threeId) {
		// TODO Auto-generated method stub
		return threedao.selectByPrimaryKey(threeId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrThree record) {
		// TODO Auto-generated method stub
		return threedao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrThree record) {
		// TODO Auto-generated method stub
		return threedao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrThree> selectAllThree() {
		// TODO Auto-generated method stub
		return threedao.selectAllThree();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return threedao.countAll();
	}

	@Override
	public int selectMaxByTwoNameAndDepartment(TrThree trThree) {
		// TODO Auto-generated method stub
		return threedao.selectMaxByTwoNameAndDepartment(trThree);
	}

	@Override
	public List<TrThree> selectMaxByTwoNameAndDepartmentAndTableName(TrThree trThree) {
		// TODO Auto-generated method stub
		return threedao.selectMaxByTwoNameAndDepartmentAndTableName(trThree);
	}

}
