package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrFunction;
@Service
public interface FunctionService {

    int deleteByPrimaryKey(String functionId);

    int insert(TrFunction record);

    int insertSelective(TrFunction record);

    TrFunction selectByPrimaryKey(String functionId);

    int updateByPrimaryKeySelective(TrFunction record);

    int updateByPrimaryKey(TrFunction record);

    List<TrFunction>selectAllFunction();
    
    int countAll();
}
