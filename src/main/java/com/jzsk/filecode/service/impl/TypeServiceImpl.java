package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.TypeDao;
import com.jzsk.filecode.model.entity.TrType;
import com.jzsk.filecode.service.TypeService;


@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao typeDao;
	
	@Override
	public int deleteByPrimaryKey(String typeId) {
		// TODO Auto-generated method stub
		return typeDao.deleteByPrimaryKey(typeId);
	}

	@Override
	public int insert(TrType record) {
		// TODO Auto-generated method stub
		return typeDao.insert(record);
	}

	@Override
	public int insertSelective(TrType record) {
		// TODO Auto-generated method stub
		return typeDao.insertSelective(record);
	}

	@Override
	public TrType selectByPrimaryKey(String typeId) {
		// TODO Auto-generated method stub
		return typeDao.selectByPrimaryKey(typeId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrType record) {
		// TODO Auto-generated method stub
		return typeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrType record) {
		// TODO Auto-generated method stub
		return typeDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrType> selectAllType() {
		// TODO Auto-generated method stub
		return typeDao.selectAllType();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return typeDao.countAll();
	}

}
