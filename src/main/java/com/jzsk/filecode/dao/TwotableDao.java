package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrTwotable;

public interface TwotableDao {

    int deleteByPrimaryKey(String twotableId);

    int insert(TrTwotable record);

    int insertSelective(TrTwotable record);

    TrTwotable selectByPrimaryKey(String twotableId);

    int updateByPrimaryKeySelective(TrTwotable record);

    int updateByPrimaryKey(TrTwotable record);
    
    List<TrTwotable> selectAllTwotable();
    
    int countAll();
    
    Integer selectMaxByTwoIdAndDepartment(TrTwotable trTwotable);
    
    List<TrTwotable> selectMaxByTwoIdAndDepartmentAndTableName(TrTwotable trTwotable);
}