package com.jzsk.filecode.dao;

import com.jzsk.filecode.model.entity.TrLog;
import com.jzsk.filecode.model.entity.TrLogKey;

public interface LogDao {

    int deleteByPrimaryKey(TrLogKey key);

    int insert(TrLog record);

    int insertSelective(TrLog record);

    TrLog selectByPrimaryKey(TrLogKey key);

    int updateByPrimaryKeySelective(TrLog record);

    int updateByPrimaryKey(TrLog record);

    int countAll();
}