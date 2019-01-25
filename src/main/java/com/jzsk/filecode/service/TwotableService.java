package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrTwotable;
@Service
public interface TwotableService {

    int deleteByPrimaryKey(String twotableId);

    int insert(TrTwotable record);

    int insertSelective(TrTwotable record);

    TrTwotable selectByPrimaryKey(String twotableId);

    int updateByPrimaryKeySelective(TrTwotable record);

    int updateByPrimaryKey(TrTwotable record);
    
    List<TrTwotable> selectAllTwotable();
    
    int countAll();
    
    int selectMaxByTwoIdAndDepartment(TrTwotable trTwotable);
    
    List<TrTwotable> selectMaxByTwoIdAndDepartmentAndTableName(TrTwotable trTwotable);
}
