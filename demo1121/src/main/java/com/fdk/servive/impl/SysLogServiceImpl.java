package com.fdk.servive.impl;


import com.fdk.bean.SysLog;
import com.fdk.dao.SysLogMapper;
import com.fdk.servive.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLog log) {
        sysLogMapper.insertSelective(log);
    }
}
