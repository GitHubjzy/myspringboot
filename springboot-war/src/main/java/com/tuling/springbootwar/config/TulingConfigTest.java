package com.tuling.springbootwar.config;

import com.tuling.springbootwar.Register.MyImportBeanDefinitionRegistrar;
import com.tuling.springbootwar.Tulingselector.TulingSelector;
import com.tuling.springbootwar.service.TulingServiceImpl;
import com.tuling.springbootwar.tuling.TulingAspect;
import com.tuling.springbootwar.tuling.TulingCondition;
import com.tuling.springbootwar.tuling.TulingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Configuration
@Import(value = {TulingSelector.class, MyImportBeanDefinitionRegistrar.class})
public class TulingConfigTest {

    @Bean
    public TulingAspect tulingAspect(){
        System.out.println("往容器中加载tulingAspect.........");
        return new TulingAspect();
    }

    @Bean
    @Conditional(value= TulingCondition.class)
    public TulingLog tulingLog(){
        System.out.println("tuling Log 加载到容器中。。。。。。。");
        return new TulingLog();
    }
}
