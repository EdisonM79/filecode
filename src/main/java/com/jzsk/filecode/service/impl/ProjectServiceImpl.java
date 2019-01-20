package com.jzsk.filecode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.ProjectDao;
import com.jzsk.filecode.model.entity.TrProject;
import com.jzsk.filecode.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public int deleteByPrimaryKey(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.deleteByPrimaryKey(projectId);
	}

	@Override
	public int insert(TrProject record) {
		// TODO Auto-generated method stub
		return projectDao.insert(record);
	}

	@Override
	public int insertSelective(TrProject record) {
		// TODO Auto-generated method stub
		return projectDao.insertSelective(record);
	}

	@Override
	public TrProject selectByPrimaryKey(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.selectByPrimaryKey(projectId);
	}

	@Override
	public int updateByPrimaryKeySelective(TrProject record) {
		// TODO Auto-generated method stub
		return projectDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TrProject record) {
		// TODO Auto-generated method stub
		return projectDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TrProject> selectAllProject() {
		// TODO Auto-generated method stub
		return projectDao.selectAllProject();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return projectDao.countAll();
	}

}
