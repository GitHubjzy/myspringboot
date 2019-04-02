package com.tuling.springbootwar.Register;

import com.tuling.springbootwar.dao.TulingDao;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //定义一个BeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition(TulingDao.class);
        beanDefinitionRegistry.registerBeanDefinition("tulingDao",beanDefinition);
    }
}
