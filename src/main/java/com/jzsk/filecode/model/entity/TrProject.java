package com.jzsk.filecode.model.entity;

import java.util.Date;

public class TrProject {

    private String projectId;

    private String projectName;

    private String projectCode;

    private String createUser;

    private Date createTime;

    private String islock;

    private String delete;

    private Date deleteTime;

    private String deleteUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.project_id
     *
     * @return the value of project.project_id
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.project_id
     *
     * @param projectId the value for project.project_id
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.project_name
     *
     * @return the value of project.project_name
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.project_name
     *
     * @param projectName the value for project.project_name
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.project_code
     *
     * @return the value of project.project_code
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.project_code
     *
     * @param projectCode the value for project.project_code
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.create_user
     *
     * @return the value of project.create_user
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.create_user
     *
     * @param createUser the value for project.create_user
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.create_time
     *
     * @return the value of project.create_time
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.create_time
     *
     * @param createTime the value for project.create_time
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.islock
     *
     * @return the value of project.islock
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getIslock() {
        return islock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.islock
     *
     * @param islock the value for project.islock
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setIslock(String islock) {
        this.islock = islock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.delete
     *
     * @return the value of project.delete
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getDelete() {
        return delete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.delete
     *
     * @param delete the value for project.delete
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setDelete(String delete) {
        this.delete = delete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.delete_time
     *
     * @return the value of project.delete_time
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.delete_time
     *
     * @param deleteTime the value for project.delete_time
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.delete_user
     *
     * @return the value of project.delete_user
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public String getDeleteUser() {
        return deleteUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.delete_user
     *
     * @param deleteUser the value for project.delete_user
     *
     * @mbggenerated Thu Jan 10 19:07:14 CST 2019
     */
    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }
}