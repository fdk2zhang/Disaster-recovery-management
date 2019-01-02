package com.fdk.config;


import com.fdk.reaml.UserRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig  {


    /*
    * 创建sessionMessager 管理会话*/
    @Bean("sessionManager")
    public SessionManager sessionManager(){
        //创建sessionManager
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();

        //设置session的过期时间
        sessionManager.setGlobalSessionTimeout(1000*60*30);//半小时

        //设置清理会话的线程
        sessionManager.setSessionValidationSchedulerEnabled(true);

        //不允许地址栏拼接 sessionid
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return  sessionManager;
    }

    //security 安全
    @Bean(name="securityManager")
    public SecurityManager securityManager(UserRealm userRealm,SessionManager sessionManager){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);

        //记住我
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        Cookie cookie = cookieRememberMeManager.getCookie();
        cookie.setMaxAge(6000);
        cookie.setPath("/");

        //设置记住我功能
        securityManager.setRememberMeManager(cookieRememberMeManager);

        //缓存管理
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        //设置缓存
        securityManager.setCacheManager(ehCacheManager);
        return  securityManager;
    }

    //配置shiroFilter  重点,
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截路径的详细设置
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("unauthorized.json");

        //LinkedHashMap能保证存取有序
        Map<String,String> map=new LinkedHashMap<>();
        map.put("/public/**","anon");
        map.put("/sys/login","anon");

        map.put("/captcha.jpg","anon");//验证码
        map.put("/**","user");//记住用户
        //map.put("/**","authc");//所有请求必须认证后才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //配置lifecyccleBean
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    //设置shiro 的注解在Spring容器中使用
    @Bean("defaultAdvisorAutoProxyCreator")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        //设置使用到shiro注解的类底层创建代理对象的方式 cglib 因为在controller使用注解
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
