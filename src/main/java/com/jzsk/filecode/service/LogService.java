package com.jzsk.filecode.service;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrLog;
import com.jzsk.filecode.model.entity.TrLogKey;

@Service
public interface LogService {

    int deleteByPrimaryKey(TrLogKey key);

    int insert(TrLog record);

    int insertSelective(TrLog record);

    TrLog selectByPrimaryKey(TrLogKey key);

    int updateByPrimaryKeySelective(TrLog record);

    int updateByPrimaryKey(TrLog record);
}
