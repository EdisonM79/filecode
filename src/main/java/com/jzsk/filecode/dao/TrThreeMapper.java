package com.jzsk.filecode.dao;

import com.jzsk.filecode.model.entity.TrThree;

public interface TrThreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    int deleteByPrimaryKey(String threeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    int insert(TrThree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    int insertSelective(TrThree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    TrThree selectByPrimaryKey(String threeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    int updateByPrimaryKeySelective(TrThree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three
     *
     * @mbggenerated Wed Jan 30 09:40:15 CST 2019
     */
    int updateByPrimaryKey(TrThree record);
}