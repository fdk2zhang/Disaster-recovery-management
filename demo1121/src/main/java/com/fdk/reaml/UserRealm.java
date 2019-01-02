package com.fdk.reaml;

import com.fdk.bean.SysUser;
import com.fdk.servive.MenusService;
import com.fdk.servive.RoleService;
import com.fdk.servive.UsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UsersService usersService;
    @Resource
    private RoleService roleService;
    @Resource
    private MenusService menusService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权.........");
        //sys_user   sys_role   sys_user_role
        //sys_menu  sys_role_menu
        // System.out.println("principals----->"+principals);

        //得到用户
        SysUser user=(SysUser)principals.getPrimaryPrincipal();
        //得到用户的角色
        List<String> roles=roleService.findRoleByUserId(user.getUserId());
        //得到用户的权限
        List<String> perms=menusService.findPermsByUserId(user.getUserId());

        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(perms);


        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证..........");

        //得到用户名和密码
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
        String username=usernamePasswordToken.getUsername();
        String password=new String(usernamePasswordToken.getPassword());

        //得到的数据和数据库的得到的数据作比较
        System.out.println("认证的用户名为"+username);
        SysUser sysUser=usersService.findUserByName(username);
        System.out.println("得到的用户名为"+sysUser);
        if(sysUser==null){
            throw  new UnknownAccountException("账号不存在");
        }
        if(!sysUser.getPassword().equals(password)){
            throw  new IncorrectCredentialsException("账号密码不正确");
        }if(sysUser.getStatus()!=1){
            throw new LockedAccountException("账号被冻结");
        }

        //封装AuthenticationInfo 对象
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(sysUser,password,this.getName());

        return info;
    }
}
