package com.tuling.springbootwar.Tulingselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
public class TulingSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.tuling.springbootwar.service.TulingServiceImpl"};
    }
}
