package com.fdk.controller;

import com.fdk.bean.SysMenu;
import com.fdk.bean.SysUser;
import com.fdk.log.MyLog;
import com.fdk.servive.MenusService;
import com.fdk.utils.R;
import com.fdk.utils.ShiroUtils;
import com.fdk.utils.TableResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MenusController {
    @Resource
    private MenusService menusService;

    @MyLog("查看菜单列表")
    @RequiresPermissions("sys:menu:list")
    @RequestMapping("/sys/menu/list")
    public TableResult findMenuList(int offset ,int limit,String search){
        return menusService.findMenuList(offset ,limit, search);
    }

    //删除菜单
    @MyLog("删除菜单")
    @RequiresPermissions("sys:menu:del")
    @RequestMapping("/sys/menu/del")
    public R del(@RequestBody List<Long> ids){// [1,2];

        return  menusService.del(ids);
    }

    //添加菜单
        //获取树形菜单
    @MyLog("查看菜单")
    @RequiresPermissions("sys:menu:select")
    @RequestMapping("/sys/menu/select")
    public R selectTreeMenu(){
        return  menusService.findMenuNotButton();
    }

    //根据传递过来的参数有无id决定是更改还是添加

    //新增
    @MyLog("新增菜单")
    @RequiresPermissions("sys:menu:save")
    @RequestMapping("/sys/menu/save")
    public R addMenu(@RequestBody SysMenu menu){
        return  menusService.insert(menu);
    }



    //更改数据,先查到数据,在更改数据,
    @MyLog("根据编号查看菜单")
    @RequiresPermissions("sys:menu:info")
    @RequestMapping("/sys/menu/info/{menuId}")
    public R selectMenuById(@PathVariable Long menuId){
        return menusService.findById(menuId);
    }


    @MyLog("修改菜单")
    @RequiresRoles("admin")
    @RequestMapping("sys/menu/update")
    public R updateMenu(@RequestBody SysMenu menu){
        return menusService.updateMenu(menu);

    }

    @RequestMapping("sys/menu/user")
    public R getMenuList(){
        //得到当前用户
        SysUser sysUser= ShiroUtils.getCurrentUser();
        return menusService.findMenu(sysUser.getUserId());
    }


}
