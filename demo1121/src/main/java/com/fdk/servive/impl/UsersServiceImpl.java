package com.fdk.servive.impl;

import com.fdk.bean.SysUser;
import com.fdk.bean.SysUserExample;
import com.fdk.dao.SysUserMapper;
import com.fdk.servive.UsersService;
import com.fdk.utils.R;
import com.fdk.utils.TableResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {



    @Resource
    private SysUserMapper sysUserMapper;

    //得到所有用户数据
    @Override
    public TableResult getUserList(int offset, int limit, String search) {

        //分页工具
        PageHelper.offsetPage(offset,limit);

        //封装模查条件
        SysUserExample example=null;
        //模糊查询条件不为空,
        if (search!=null&&!"".equals(search)){
           // 创建了条件容器
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUsernameLike("%"+search+"%");
        }

        List<SysUser> list = sysUserMapper.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        TableResult tableResult=new TableResult();
        tableResult.setRows(pageInfo.getList());
        tableResult.setTotal(pageInfo.getTotal());

        return tableResult;
    }

    @Override
    public R addUser(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUser.setStatus((byte)1);
        sysUser.setCreateUserId(1l);//创建人的id,L字母结尾,1L ,不是数字11

        sysUser.setPassword(new Md5Hash(sysUser.getPassword(),sysUser.getUsername(),1024).toString());

        int i=sysUserMapper.insert(sysUser);
        return i>0?R.ok("添加成功"):R.error("添加失败");
    }

    @Override
    public R findUserById(Long userId) {
        SysUser sysUser=sysUserMapper.selectByPrimaryKey(userId);
        if (sysUser!=null){
            return R.ok().put("user",sysUser);
        }
        return R.error();
    }

    @Override
    public R updateUser(SysUser sysUser) {
        int i=sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return i>0?R.ok("修改成功"):R.error("修改失败");
    }

    @Override
    public R deleteUser(List<Long> ids) {
        for(Long id:ids){
            if(id==1){
                return  R.error("管理员不能删除");
            }
        }
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdIn(ids);

        int i=sysUserMapper.deleteByExample(example);

        return i>0?R.ok():R.error();
    }

    @Override
    public SysUser findUserByName(String username) {
        System.out.println("servive...........");
        List<SysUser> list =sysUserMapper.findUserByName(username);
        if(list!=null&& list.size()>0){
            System.out.println(list.get(0));
            return  list.get(0);
        }
        return null;
    }

}
