/*
package com.tuling.springbootwar.config;

import com.tuling.springbootwar.Intercepter.LoginInterceptor;
import com.tuling.springbootwar.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

*/
/**
 * @author jizy
 * @create 2019/3/31
 * @since 1.0.0
 *//*

@Configuration
@EnableWebMvc
public class TulingConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginInterceptor loginInterceptor;

    */
/**
     * 注册拦截器
     * @param registry
     *//*

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html");
    }

    */
/**
     * 注册过滤器
     * @return
     *//*

    @Bean
    public FilterRegistrationBean loginFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
    */
/**
     * 注册视图控制器
     * @param registry
     *//*

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login.html");
    }
}
//*/