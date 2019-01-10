package com.jzsk.filecode.service;

import com.jzsk.filecode.model.entity.TrFunction;

public interface FunctionService {

    int deleteByPrimaryKey(String functionId);

    int insert(TrFunction record);

    int insertSelective(TrFunction record);

    TrFunction selectByPrimaryKey(String functionId);

    int updateByPrimaryKeySelective(TrFunction record);

    int updateByPrimaryKey(TrFunction record);
}
