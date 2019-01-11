package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.entity.TrDocument;

@Service
public interface DocumentService {
    
    int deleteByPrimaryKey(String documentId);

    int insert(TrDocument record);

    int insertSelective(TrDocument record);

    TrDocument selectByPrimaryKey(String documentId);

    int updateByPrimaryKeySelective(TrDocument record);

    int updateByPrimaryKey(TrDocument record);
    
    List<TrDocument> selectAllDocument();
}
