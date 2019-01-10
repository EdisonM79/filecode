package com.jzsk.filecode.service;

import com.jzsk.filecode.model.entity.TrType;

public interface TypeService {

    int deleteByPrimaryKey(String typeId);

    int insert(TrType record);

    int insertSelective(TrType record);

    TrType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(TrType record);

    int updateByPrimaryKey(TrType record);
}
