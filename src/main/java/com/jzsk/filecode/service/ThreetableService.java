package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrThreetable;
@Service
public interface ThreetableService {

    int deleteByPrimaryKey(String threetableId);

    int insert(TrThreetable record);

    int insertSelective(TrThreetable record);

    TrThreetable selectByPrimaryKey(String threetableId);

    int updateByPrimaryKeySelective(TrThreetable record);

    int updateByPrimaryKey(TrThreetable record);
    
    List<TrThreetable> selectAllThreetable();
    
    int countAll();
    
    int selectMaxByThreeNum(String threeNum);
    
    int selectMaxByDepartment(TrThreetable record);
    
    List<TrThreetable> selectMaxByThreeIdAndDepartmentAndTableName(TrThreetable record);
}
