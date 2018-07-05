package com.mikeleitz.example.annotation;

import com.mikeleitz.example.service.NotifyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @author Mike Leitz
 */
@Aspect
@Component
public class MyExampleAnnotationAspect implements ApplicationContextAware {
    private Logger _logger = LoggerFactory.getLogger(MyExampleAnnotationAspect.class);

    /**
     * For our aspect, we're using compile time weaving (as opposed to having Spring handle managing the aspect).
     *
     * One of the negatives of this approach is that Spring's @Autowired doesn't work out of the
     * box.  This is because the code is compiled in at build time, instead of having
     * Spring handle it at startup.
     *
     * It's easy to have your compiled aspect use Spring beans, however.  Simply implement
     * ApplicationContextAware and set any beans manually.  Make sure the variables
     * are declared static.
     *
     * You probably won't encounter this use-case (interact with Spring beans) often in your
     * aspects but I included it in this example.
     *
     * If you don't prefer this build-time approach, see the README.md file.  The README.md will enumerate the pros/cons
     * of both Spring vs non-Spring and let you know how to implement a 100% Spring solution.
     */
    private static NotifyService _notifyService;

    @Around("execution(@com.mikeleitz.example.annotation.MyExampleAnnotation * *(..))")
    public Object myExampleAnnotationAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue;

        _logger.debug("Started executing advice.  Running this code because we've encountered a method annotated with @MyExampleAnnotation.");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Object[] args = joinPoint.getArgs();
        String inputParamValue = (String) args[0];

        MyExampleAnnotation annotation = method.getAnnotation(MyExampleAnnotation.class);
        SeverityEnum severity = annotation.severity();

        returnValue = joinPoint.proceed();

        if (SeverityEnum.CRITICAL == severity || SeverityEnum.HIGH == severity) {
            _logger.info("The annotation was marked as HIGH or CRITICAL.  Going to call another service to notify support.");

            _notifyService.escalateToSupport(severity, inputParamValue, (String) returnValue);
        } else {
            _logger.debug("The annotation has severity lower than High.  Not notifying support.");
        }

        _logger.info("Completed executing advice on method annotated with @MyExampleAnnotation.");

        return returnValue;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        _notifyService = applicationContext.getBean(NotifyService.class);
    }
}
