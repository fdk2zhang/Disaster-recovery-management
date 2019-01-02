package com.fdk.servive;

import com.fdk.bean.ScheduleJob;
import com.fdk.utils.R;
import com.fdk.utils.TableResult;

import java.util.List;

public interface ScheduleJobService {

    public R saveScheduleJob(ScheduleJob scheduleJob);

    public TableResult jobList(int offset, int limit, String search);

    public R delJob(List<Long> ids) ;
    public R resumeJob(List<Long> ids) ;
    public R pauseJob(List<Long> ids) ;
    public R runJob(List<Long> ids) ;


    public  R scheduleInfo(long jobId);

    public R update(ScheduleJob scheduleJob);
}
