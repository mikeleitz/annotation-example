package com.mikeleitz.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mike Leitz
 */
@Configuration
@ComponentScan("com.mikeleitz.example.annotation")
public class AspectAnnotationConfiguration {
    private Logger _logger = LoggerFactory.getLogger(AspectAnnotationConfiguration.class);
}
