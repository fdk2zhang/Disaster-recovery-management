package com.fdk.bean;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJobLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.log_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Long logId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Long jobId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String beanName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String methodName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String params;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.error
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private String error;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.times
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Integer times;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job_log.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.log_id
     *
     * @return the value of schedule_job_log.log_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.log_id
     *
     * @param logId the value for schedule_job_log.log_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.job_id
     *
     * @return the value of schedule_job_log.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.job_id
     *
     * @param jobId the value for schedule_job_log.job_id
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.bean_name
     *
     * @return the value of schedule_job_log.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.bean_name
     *
     * @param beanName the value for schedule_job_log.bean_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.method_name
     *
     * @return the value of schedule_job_log.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.method_name
     *
     * @param methodName the value for schedule_job_log.method_name
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.params
     *
     * @return the value of schedule_job_log.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.params
     *
     * @param params the value for schedule_job_log.params
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.status
     *
     * @return the value of schedule_job_log.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.status
     *
     * @param status the value for schedule_job_log.status
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.error
     *
     * @return the value of schedule_job_log.error
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public String getError() {
        return error;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.error
     *
     * @param error the value for schedule_job_log.error
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setError(String error) {
        this.error = error == null ? null : error.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.times
     *
     * @return the value of schedule_job_log.times
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.times
     *
     * @param times the value for schedule_job_log.times
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job_log.create_time
     *
     * @return the value of schedule_job_log.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job_log.create_time
     *
     * @param createTime the value for schedule_job_log.create_time
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}