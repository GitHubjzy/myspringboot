package com.tuling.springbootwar.tuling;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
public class TulingCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if(conditionContext.getBeanFactory().containsBean("tulingAspect")){
            return true;
        }
        return false;
    }
}
