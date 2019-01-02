package com.fdk.controller;

import com.fdk.bean.SysUser;
import com.fdk.dao.SysUserMapper;
import com.fdk.dto.SysUserDTO;
import com.fdk.log.MyLog;
import com.fdk.servive.UsersService;
import com.fdk.utils.R;
import com.fdk.utils.ShiroUtils;
import com.fdk.utils.SysConstant;
import com.fdk.utils.TableResult;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.List;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @Resource
    private Producer producer;


    //验证码
    @MyLog("生成验证码")
    @RequestMapping("/captcha.jpg")
    public  void captcha(HttpServletResponse response) throws Exception{
        String text=producer.createText();
        System.out.println("验证码--->"+text);

        //存储到域对象
        ShiroUtils.setAttribute(SysConstant.CODE_KEY,text);

        //存储验证码
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image,"jpg",response.getOutputStream());
    }


    @MyLog("登录")
    @RequestMapping("/sys/login")
    public R login(@RequestBody SysUserDTO user){
        System.out.println("login:"+user);

        //得到系统生成的验证码
        String text = (String) ShiroUtils.getAttribute(SysConstant.CODE_KEY);

        //判断系统的验证码
        if (!text.equalsIgnoreCase(user.getCaptcha())){//
            return R.error("验证码不正确");
        }



        Md5Hash md5Hash=new Md5Hash(user.getPassword(),user.getUsername(),1024);
        user.setPassword(md5Hash.toString());

        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject= SecurityUtils.getSubject();

        //登录
        try{
            //记住我的功能
            if(user.isRememberMe()){
                token.setRememberMe(true);
            }
            subject.login(token);//调用自定义Realm进行认证和授权
            System.out.println("是否有权限");

            System.out.println(subject.isPermitted("sys:user:select"));
            System.out.println(subject.isPermitted("sys:role:select"));

            return R.ok();
        }catch (Exception e){
            return R.error(e.getMessage());
        }

    }


    //得到所有用户信息
    @MyLog("查看用户列表")
    @RequiresPermissions("sys:user:list")
    @RequestMapping("/sys/user/list")
    public TableResult getUserList(int offset , int limit, String search){
        return  usersService.getUserList(offset ,limit,search);
    }

    //添加用户
    @MyLog("新增用户")
    @RequiresPermissions("sys:user:save")
    @RequestMapping("/sys/user/save")
    public R addUser(@RequestBody SysUser sysUser){
        return  usersService.addUser(sysUser);
    }

    //根据编号查询用户
    @MyLog("查看用户")
    @RequiresPermissions("sys:user:info")
    @RequestMapping("/sys/user/info/{userId}")
    public R findUserById(@PathVariable Long userId){
        return usersService.findUserById(userId);
    }

    //更改用户
    @MyLog("修改用户")
    @RequiresPermissions("sys:user:update")
    @RequestMapping("/sys/user/update")
    public R updateUser(@RequestBody SysUser sysUser){

        return usersService.updateUser(sysUser);
    }

    //删除用户
    @MyLog("删除用户")
    @RequiresPermissions("sys:user:del")
    @RequestMapping("/sys/user/del")
    public R deleteUser(@RequestBody  List<Long> ids){
        return usersService.deleteUser(ids);
    }

    @MyLog("退出")
    @RequestMapping("/logout")
    public  void logout(){

        ShiroUtils.logout();

//         return "/login.html";
    }

    @RequestMapping("sys/user/info")
    public R userInfo(){
        SysUser sysUser  = ShiroUtils.getCurrentUser();
        return R.ok().put("user",sysUser);
    }
}
