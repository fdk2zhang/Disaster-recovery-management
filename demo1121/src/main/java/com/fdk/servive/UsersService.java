package com.fdk.servive;

import com.fdk.bean.SysUser;
import com.fdk.utils.R;
import com.fdk.utils.TableResult;

import java.util.List;

public interface UsersService {

    public TableResult getUserList(int offset , int limit, String search);

    //添加用户
    public R addUser(SysUser sysUser);

    //按照编号查询用户
    public R findUserById(Long userId);

    //修改用户
    public R updateUser(SysUser sysUser);

    //删除用户
    public R deleteUser(List<Long> ids);

    //按照用户名查询用户
    public SysUser  findUserByName(String username);
}
