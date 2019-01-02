package com.fdk.servive.impl;


import com.fdk.bean.ScheduleJob;
import com.fdk.bean.ScheduleJobExample;
import com.fdk.bean.ScheduleJobLogExample;
import com.fdk.dao.ScheduleJobMapper;
import com.fdk.servive.ScheduleJobService;
import com.fdk.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Resource
    private ScheduleJobMapper scheduleJobMapper;
    @Resource
    private Scheduler scheduler;//QuartzConfig文件中创建的

    //添加
    @Override
    public R saveScheduleJob(ScheduleJob scheduleJob) {
        scheduleJob.setStatus(SysConstant.SchedulerStatus.NOMAL.getValue());//正常状态
        scheduleJob.setCreateTime(new Date());

        //持久化到数据库
        int i=scheduleJobMapper.insert(scheduleJob);
        //真正任务的创建
        SchedulerUtils.createScheduler(scheduleJob,scheduler);
        return i>0?R.ok("新增成功"):R.error("新增失败");
    }

    //得到任务列表
    @Override
    public TableResult jobList(int offset, int limit, String search) {
        PageHelper.offsetPage(offset,limit);
        ScheduleJobExample example=null;
        if(StringUtils.isNotEmpty(search)){
            example=new ScheduleJobExample();
            example.createCriteria().andBeanNameLike("%"+search+"%");
        }
        List<ScheduleJob> list= scheduleJobMapper.selectByExample(example);
        PageInfo info=new PageInfo<ScheduleJob>(list);

        TableResult result=new TableResult();
        result.setRows(info.getList());
        result.setTotal(info.getTotal());

        return result;
    }

    @Override
    public R delJob(List<Long> ids) {
        //1.调用dao删除schedule_Job表中的数据
        ScheduleJobExample example = new ScheduleJobExample();
        example.createCriteria().andJobIdIn(ids);
        int i=scheduleJobMapper.deleteByExample(example);

        //2.调用ScheduleUtils实现真正的任务删除
        if(1>0){
            for(Long id:ids){
                ScheduleJob job=new ScheduleJob();
                job.setJobId(id);
                SchedulerUtils.delJob(job,scheduler);
            }
        }
        return R.ok("删除成功");
    }

    //恢复
    @Override
    public R resumeJob(List<Long> ids) {
        //1.修改数据库中任务的状态 nomal
        ScheduleJob scheduleJob=new ScheduleJob();
        scheduleJob.setStatus(SysConstant.SchedulerStatus.NOMAL.getValue());
        //where job_id in (1,2,3);

        ScheduleJobExample example=new ScheduleJobExample();
        example.createCriteria().andJobIdIn(ids);
        int i=scheduleJobMapper.updateByExampleSelective(scheduleJob,example);

        //恢复任务
        if(i>0){
            for(Long id:ids){
                scheduleJob=new ScheduleJob();
                scheduleJob.setJobId(id);
                SchedulerUtils.resumeJob(scheduleJob,scheduler);
            }
        }
        return R.ok("恢复成功");
    }

    //暂停
    @Override
    public R pauseJob(List<Long> ids) {
        //1.修改数据库中的任务状态 nomal
        ScheduleJob scheduleJob=new ScheduleJob();
        scheduleJob.setStatus(SysConstant.SchedulerStatus.PAUSE.getValue());
        //where job_id in (1,2,3);
        ScheduleJobExample example = new ScheduleJobExample();
        example.createCriteria().andJobIdIn(ids);
        int i =  scheduleJobMapper.updateByExampleSelective(scheduleJob,example);

        //2.恢复定时任务
        if(i>0){
            for (Long id : ids) {
                scheduleJob = new ScheduleJob();
                scheduleJob.setJobId(id);
                SchedulerUtils.pauseJob(scheduleJob,scheduler);
            }
        }
        return R.ok("暂停任务成功");
    }

    @Override
    public R runJob(List<Long> ids) {
        //2,恢复定时任务
        ScheduleJob scheduleJob = null;
        for (Long id : ids) {
            scheduleJob = new ScheduleJob();
            scheduleJob.setJobId(id);
            SchedulerUtils.runJob(scheduleJob,scheduler);//运行一次

        }
        return R.ok("运行成功");

    }


    @Override
    public R scheduleInfo(long jobId) {
        return null;
    }

    @Override
    public R update(ScheduleJob scheduleJob) {
        return null;
    }
}
