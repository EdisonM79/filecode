package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrFunction;

public interface FunctionDao {

    int deleteByPrimaryKey(String functionId);

    int insert(TrFunction record);

    int insertSelective(TrFunction record);

    TrFunction selectByPrimaryKey(String functionId);

    int updateByPrimaryKeySelective(TrFunction record);

    int updateByPrimaryKey(TrFunction record);
    
    List<TrFunction>selectAllFunction();
}