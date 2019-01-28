package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrThree;

public interface ThreeDao {

    int deleteByPrimaryKey(String threeId);

    int insert(TrThree record);

    int insertSelective(TrThree record);

    TrThree selectByPrimaryKey(String threeId);

    int updateByPrimaryKeySelective(TrThree record);

    int updateByPrimaryKey(TrThree record);
    
    List<TrThree> selectAllThree();
    
    int countAll();
    
    int selectMaxByTwoNameAndDepartment(TrThree trThree);
    
    List<TrThree> selectMaxByTwoNameAndDepartmentAndTableName(TrThree trThree);
    
    List<TrThree> selectLatestThreeList();
}