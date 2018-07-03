package com.mikeleitz.example.annotation.service;

import com.mikeleitz.example.annotation.annotation.MyExampleAnnotation;
import com.mikeleitz.example.annotation.annotation.SeverityEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * This service has one method reverseMyInput and that method is annotated with our
 * custom annotation : @MyExampleAnnotation.
 *
 * When this method is called, the application will see that there is a AOP aspect associated
 * with the annotation and divert the execution into the advice.
 *
 * @author Mike Leitz
 */
@Service
public class AnnotatedExampleServiceImpl implements AnnotatedExampleService {
    private Logger _logger = LoggerFactory.getLogger(AnnotatedExampleServiceImpl.class);

    @Override
    @MyExampleAnnotation(severity = SeverityEnum.CRITICAL)
    public String reverseMyInput(String input) {
        return StringUtils.reverse(input);
    }
}
