package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrTwo;

@Service
public interface TwoService {

	
    int deleteByPrimaryKey(String twoId);

    int insert(TrTwo record);

    int insertSelective(TrTwo record);

    TrTwo selectByPrimaryKey(String twoId);

    int updateByPrimaryKeySelective(TrTwo record);

    int updateByPrimaryKey(TrTwo record);
    
    List<TrTwo> selectAllTwo();
    
    int countAll();

}
