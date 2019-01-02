package com.fdk.servive.impl;

import com.fdk.bean.SysMenu;
import com.fdk.bean.SysMenuExample;
import com.fdk.dao.SysMenuMapper;
import com.fdk.servive.MenusService;
import com.fdk.utils.R;
import com.fdk.utils.TableResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MenusServiceImpl implements MenusService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public TableResult findMenuList(int offset ,int limit,String search) {
        PageHelper.offsetPage(offset,limit);

        SysMenuExample example=null;
        if(search!=null&&!"".equals(search)){
            example=new SysMenuExample();
            SysMenuExample.Criteria criteria=example.createCriteria();
            criteria.andNameLike("%"+search+"%");
        }
        List<SysMenu> list =sysMenuMapper.selectByExample(example);

        PageInfo<SysMenu> pageInfo=new PageInfo<>(list);

        TableResult tableResult=new TableResult();
        tableResult.setTotal(pageInfo.getTotal());
        tableResult.setRows(pageInfo.getList());
        return tableResult;
    }


    //批量删除
    @Override
    public R del(List<Long> ids) {
        for(Long id:ids){
            if(id<29){
                return  R.error("系统菜单不能删除");
            }
        }
        SysMenuExample example =new SysMenuExample();
        SysMenuExample.Criteria c=example.createCriteria();
        c.andMenuIdIn(ids);

        int i=sysMenuMapper.deleteByExample(example);
        return i>0?R.ok("删除成功"):R.error("删除失败");
    }

    @Override
    public R findMenuNotButton() {
        //得到除了按钮以外的菜单数据
        List<SysMenu> list =sysMenuMapper.findMenuNotButton();

        //创建一个一级目录,为了创建和系统菜单一个级别的目录
        SysMenu menu=new SysMenu();
        menu.setMenuId(0L);//L long 数据为long 类型
        menu.setParentId(-1L);
        menu.setName("一级菜单");
        menu.setType(0);
        list.add(menu);
        return R.ok().put("menuList",list);
    }

    @Override
    public R insert(SysMenu menu) {
        int i =sysMenuMapper.insertSelective(menu);
        return i>0?R.ok("新增成功"):R.ok("新增失败");
    }



    @Override
    public R findById(Long menuId) {
        SysMenu sysMenu=sysMenuMapper.selectByPrimaryKey(menuId);
        if (sysMenu!=null){
            return R.ok().put("menu",sysMenu);
        }
        return R.error("没有这个菜单");
    }

    @Override
    public R updateMenu(SysMenu sysMenu) {
        int i=sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        return i>0?R.ok("修改成功"):R.error("修改失败");
    }

    @Override
    public List<String> findPermsByUserId(long userId) {
        List<String> list=sysMenuMapper.findPermsByUserId(userId);

        //使用set集合去除重复的权限
        Set<String> set=new HashSet<>();
        for (String s:list){
            if(s!=null&&!s.equals("")){
                String ss[] = s.split(",");
                for (String s1 : ss) {
                    set.add(s1);
                }
            }
        }

        //把得到的权限放入list集合
        List<String> perms=new ArrayList<>();
        perms.addAll(set);
        return perms;
    }

    @Override
    public R findMenu(long userId) {
        //系统菜单
        //任务管理
        List<Map<String,Object>> parentMenu=sysMenuMapper.findParentMenuByUserId(userId);
            /* Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu);*/

            for(Map<String,Object> map:parentMenu){
                Long menuId=(Long) map.get("menu_id");
                //查询菜单下的子菜单
                List<Map<String,Object>> menuMap=sysMenuMapper.findMenuByUserId(userId,menuId);
                map.put("list",menuMap);
            }
            List<String> perms=this.findPermsByUserId(userId);

        return R.ok().put("menuList",parentMenu).put("permissions",perms);
    }
}
