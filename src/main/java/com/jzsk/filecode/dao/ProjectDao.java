package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrProject;

public interface ProjectDao {

    int deleteByPrimaryKey(String projectId);

    int insert(TrProject record);

    int insertSelective(TrProject record);

    TrProject selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(TrProject record);

    int updateByPrimaryKey(TrProject record);
    
    List<TrProject>selectAllProject();
}