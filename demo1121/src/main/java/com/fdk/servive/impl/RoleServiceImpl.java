package com.fdk.servive.impl;

import com.fdk.dao.SysRoleMapper;
import com.fdk.servive.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<String> findRoleByUserId(long userId) {
        return sysRoleMapper.findRoleNameByUserId(userId);
    }
}
