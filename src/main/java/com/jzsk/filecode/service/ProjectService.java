package com.jzsk.filecode.service;

import com.jzsk.filecode.model.entity.TrProject;

public interface ProjectService {

    int deleteByPrimaryKey(String projectId);

    int insert(TrProject record);

    int insertSelective(TrProject record);

    TrProject selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(TrProject record);

    int updateByPrimaryKey(TrProject record);
}
