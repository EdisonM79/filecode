package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrProject;
@Service
public interface ProjectService {

    int deleteByPrimaryKey(String projectId);

    int insert(TrProject record);

    int insertSelective(TrProject record);

    TrProject selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(TrProject record);

    int updateByPrimaryKey(TrProject record);
    
    List<TrProject>selectAllProject();
}
