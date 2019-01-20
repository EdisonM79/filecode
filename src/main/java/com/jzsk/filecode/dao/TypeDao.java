package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrType;

public interface TypeDao {

    int deleteByPrimaryKey(String typeId);

    int insert(TrType record);

    int insertSelective(TrType record);

    TrType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(TrType record);

    int updateByPrimaryKey(TrType record);
    
    List<TrType>selectAllType();

    int countAll();
}