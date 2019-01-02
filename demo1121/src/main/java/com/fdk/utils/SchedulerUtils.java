package com.fdk.utils;

import com.alibaba.fastjson.JSON;
import com.fdk.bean.ScheduleJob;
import com.fdk.job.MyQuartzJobBean;
import org.quartz.*;

/**
 * 工具类
 * 完成任务,对任务的操控
 * 创建,修改,删除,暂停,恢复
 */
public class SchedulerUtils {
    /**
     * 创建定时任务
     * Scheduler   JobDetail  Trigger
     *
     * @param scheduleJob been包下的实体类，一个scheduleJob对象描述一个定时任务
     * @param scheduler   任务调度器
     */
    public static void createScheduler(ScheduleJob scheduleJob, Scheduler scheduler) {
        System.out.println("创建定时任务......" + scheduleJob.getJobId());
        //1.jobdetail
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJobBean.class)
                .withIdentity(SysConstant.JOB_KEY_PREFIX + scheduleJob.getJobId()).build();


        //向 MyQuartzJobBean  传递数据
        String json = JSON.toJSONString(scheduleJob);
        jobDetail.getJobDataMap().put(SysConstant.SCHEDULE_DATA_KEY,json);

        //2.创建触发器 tigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()))
                .withIdentity(SysConstant.TRIGGER_KET_PREFIX + scheduleJob.getJobId()).build();

        //3.schedule已经创建好，在QuartzConfig类中已经创建
        //4.注册任务和触发器
        try {

            scheduler.scheduleJob(jobDetail, trigger);
            //启动任务
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RRException("创建任务失败！");
        }


    }

    public static  void runJob(ScheduleJob scheduleJob,Scheduler scheduler){
        //运行任务

        System.out.println("运行任务");
        try {
            scheduler.triggerJob(JobKey.jobKey(SysConstant.JOB_KEY_PREFIX+scheduleJob.getJobId()));
        } catch (SchedulerException e) {
            throw new RRException("运行失败");
        }

    }


    /**
     * 暂停执行
     */
    public static  void pauseJob(ScheduleJob scheduleJob,Scheduler scheduler){
        try {
            scheduler.pauseJob(JobKey.jobKey(SysConstant.JOB_KEY_PREFIX+scheduleJob.getJobId()));
        } catch (SchedulerException e) {
            throw  new RRException("暂停任务失败！");
        }
    }

    public static void resumeJob(ScheduleJob scheduleJob ,Scheduler scheduler){
        try {
            scheduler.resumeJob(JobKey.jobKey(SysConstant.JOB_KEY_PREFIX+scheduleJob.getJobId()));
        } catch (SchedulerException e) {
            throw  new RRException("恢复任务失败！");
        }
    }

    /**
     * 修改任务 -->修改触发的条件
     * @param scheduleJob
     * @param scheduler
     */
    public static void updateJob(ScheduleJob scheduleJob,Scheduler scheduler){

        try {

            //1.先得到要修改的任务的触发器的triggerkey
            TriggerKey key=TriggerKey.triggerKey(SysConstant.TRIGGER_KET_PREFIX+scheduleJob.getJobId());
            //2.得到原来的触发器对象
            CronTrigger trigger=(CronTrigger)scheduler.getTrigger(key);
            //3.更新触发器的表达式
            trigger=trigger.getTriggerBuilder()
                    .withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())).build();
            //4.重置触发器,把触发条件添加进触发器
        } catch (SchedulerException e) {
            throw  new RRException("修改任务失败",e);
        }
    }

    public static void delJob(ScheduleJob scheduleJob,Scheduler scheduler){
        try {
            scheduler.deleteJob(JobKey.jobKey(SysConstant.JOB_KEY_PREFIX+scheduleJob.getJobId()));
        } catch (SchedulerException e) {
            throw  new RRException("删除任务失败！");
        }
    }
}
