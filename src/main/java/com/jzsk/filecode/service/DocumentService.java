package com.jzsk.filecode.service;

import java.util.List;

import com.jzsk.filecode.model.entity.TrDocument;

public interface DocumentService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    int deleteByPrimaryKey(String documentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    int insert(TrDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    int insertSelective(TrDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    TrDocument selectByPrimaryKey(String documentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    int updateByPrimaryKeySelective(TrDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Thu Jan 10 18:52:58 CST 2019
     */
    int updateByPrimaryKey(TrDocument record);
    
    List<TrDocument> selectAllDocument();
}
