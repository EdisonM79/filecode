package com.jzsk.filecode.model.entity;

public class TrLogKey {

    private String functionId;

    private String modelNum;

    private String projectId;

    private String typeId;

    public String getFunctionId() {
        return functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.function_id
     *
     * @param functionId the value for log.function_id
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.model_num
     *
     * @return the value of log.model_num
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public String getModelNum() {
        return modelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.model_num
     *
     * @param modelNum the value for log.model_num
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.project_id
     *
     * @return the value of log.project_id
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.project_id
     *
     * @param projectId the value for log.project_id
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.type_id
     *
     * @return the value of log.type_id
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.type_id
     *
     * @param typeId the value for log.type_id
     *
     * @mbggenerated Thu Jan 10 19:06:45 CST 2019
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}