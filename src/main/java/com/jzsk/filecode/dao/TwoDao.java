package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrTwo;

public interface TwoDao {
	
    int deleteByPrimaryKey(String twoId);

    int insert(TrTwo record);

    int insertSelective(TrTwo record);

    TrTwo selectByPrimaryKey(String twoId);

    int updateByPrimaryKeySelective(TrTwo record);

    int updateByPrimaryKey(TrTwo record);
    
    List<TrTwo> selectAllTwo();
    
    int countAll();
}