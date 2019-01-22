package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrThreetable;

public interface ThreetableDao {

    int deleteByPrimaryKey(String threetableId);

    int insert(TrThreetable record);

    int insertSelective(TrThreetable record);

    TrThreetable selectByPrimaryKey(String threetableId);

    int updateByPrimaryKeySelective(TrThreetable record);

    int updateByPrimaryKey(TrThreetable record);
    
    List<TrThreetable> selectAllThreetable();
    
    int countAll();
    
    int selectMaxByThreeNum(String threeNum);
}