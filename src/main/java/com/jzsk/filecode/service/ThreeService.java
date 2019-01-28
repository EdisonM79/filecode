package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrThree;

@Service
public interface ThreeService {

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
