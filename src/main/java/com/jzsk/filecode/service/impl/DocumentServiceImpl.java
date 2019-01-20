package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.DocumentDao;
import com.jzsk.filecode.model.entity.TrDocument;
import com.jzsk.filecode.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao documentDao;
	
	@Override
	public int deleteByPrimaryKey(String documentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TrDocument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TrDocument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TrDocument selectByPrimaryKey(String documentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TrDocument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TrDocument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TrDocument> selectAllDocument() {
		// TODO Auto-generated method stub
		return documentDao.selectAllDocument();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return documentDao.countAll();
	}

}
