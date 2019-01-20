package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrFilename;

@Service
public interface FilenameService {

    int deleteByPrimaryKey(String filenameId);

    int insert(TrFilename record);

    int insertSelective(TrFilename record);

    TrFilename selectByPrimaryKey(String filenameId);

    int updateByPrimaryKeySelective(TrFilename record);

    int updateByPrimaryKey(TrFilename record);
    
    List<TrFilename> selectAllFilecode();
    
    int countAll();
}
