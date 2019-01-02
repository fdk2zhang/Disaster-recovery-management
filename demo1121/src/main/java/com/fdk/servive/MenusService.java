package com.fdk.servive;

import com.fdk.bean.SysMenu;
import com.fdk.utils.R;
import com.fdk.utils.TableResult;

import java.util.List;
import java.util.Map;

public interface MenusService {
    public TableResult findMenuList(int offset ,int limit,String search);

    //批量删除
    public R del(List<Long> ids);

    //获取菜单数据,表现为树形结构
    public R findMenuNotButton();

    //添加新的菜单
    public R insert(SysMenu menu);

    public R findById(Long menuId);

    public R updateMenu(SysMenu sysMenu);

    public List<String> findPermsByUserId(long userid);

    //查找菜单,分级
    public R findMenu(long userId);
}
