package com.fdk.bean;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Long jobId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String beanName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String methodName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String params;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.cron_expression
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String cronExpression;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.remark
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.job_id
     *
     * @return the value of schedule_job.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.job_id
     *
     * @param jobId the value for schedule_job.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.bean_name
     *
     * @return the value of schedule_job.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.bean_name
     *
     * @param beanName the value for schedule_job.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.method_name
     *
     * @return the value of schedule_job.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.method_name
     *
     * @param methodName the value for schedule_job.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.params
     *
     * @return the value of schedule_job.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.params
     *
     * @param params the value for schedule_job.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.cron_expression
     *
     * @return the value of schedule_job.cron_expression
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.cron_expression
     *
     * @param cronExpression the value for schedule_job.cron_expression
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.status
     *
     * @return the value of schedule_job.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.status
     *
     * @param status the value for schedule_job.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.remark
     *
     * @return the value of schedule_job.remark
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.remark
     *
     * @param remark the value for schedule_job.remark
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.create_time
     *
     * @return the value of schedule_job.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.create_time
     *
     * @param createTime the value for schedule_job.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}