package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrType;
@Service
public interface TypeService {

    int deleteByPrimaryKey(String typeId);

    int insert(TrType record);

    int insertSelective(TrType record);

    TrType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(TrType record);

    int updateByPrimaryKey(TrType record);
    
    List<TrType>selectAllType();
}
