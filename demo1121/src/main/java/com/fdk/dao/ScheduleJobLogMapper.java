package com.fdk.dao;

import com.fdk.bean.ScheduleJobLog;
import com.fdk.bean.ScheduleJobLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleJobLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int countByExample(ScheduleJobLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int deleteByExample(ScheduleJobLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int deleteByPrimaryKey(Long logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int insert(ScheduleJobLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int insertSelective(ScheduleJobLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    List<ScheduleJobLog> selectByExample(ScheduleJobLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    ScheduleJobLog selectByPrimaryKey(Long logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") ScheduleJobLog record, @Param("example") ScheduleJobLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int updateByExample(@Param("record") ScheduleJobLog record, @Param("example") ScheduleJobLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int updateByPrimaryKeySelective(ScheduleJobLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job_log
     *
     * @mbggenerated Wed Nov 21 19:53:51 CST 2018
     */
    int updateByPrimaryKey(ScheduleJobLog record);
}