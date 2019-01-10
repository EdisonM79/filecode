package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrFilename;

public interface FilenameDao {

    int deleteByPrimaryKey(String filenameId);

    int insert(TrFilename record);

    int insertSelective(TrFilename record);

    TrFilename selectByPrimaryKey(String filenameId);

    int updateByPrimaryKeySelective(TrFilename record);

    int updateByPrimaryKey(TrFilename record);
    
    List<TrFilename> selectAllFilecode();
}