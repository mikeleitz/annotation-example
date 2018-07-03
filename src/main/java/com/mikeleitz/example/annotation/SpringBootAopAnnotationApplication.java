package com.mikeleitz.example.annotation;

import com.mikeleitz.example.annotation.config.AspectAnnotationConfiguration;
import com.mikeleitz.example.annotation.service.AnnotatedExampleService;
import com.mikeleitz.example.annotation.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Mike Leitz
 */
@Import(AspectAnnotationConfiguration.class)
@SpringBootApplication
public class SpringBootAopAnnotationApplication implements CommandLineRunner {
    private final static Logger _logger = LoggerFactory.getLogger(SpringBootAopAnnotationApplication.class);

    @Value("${example.input}") private String _exampleInput;

    @Autowired private ExampleService _exampleService;
    @Autowired private AnnotatedExampleService _annotatedExampleService;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootAopAnnotationApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) {
        _logger.info("*****************************************************************************************************************************************************************");
        _logger.info("Running two services.");

        _logger.info("The first service doesn't have the custom annotation and will execute normally.");
        _logger.info("The second service does have the custom annotation (in @MyExampleAnnotation) and Advice (MyExampleAnnotationAspect) will be executed along with the service code.");
        _logger.info("*****************************************************************************************************************************************************************");

        _logger.info("\n\n\n");
        _logger.info("Running the first example service using input [{}].", _exampleInput);

        String result = _exampleService.reverseMyInput(_exampleInput);

        _logger.info("Result from the first service: [{}].\n\n\n", result);

        _logger.info("Running the second example service using input [{}].", _exampleInput);

        result = _annotatedExampleService.reverseMyInput(_exampleInput);

        _logger.info("Result from the second service: [{}].\n\n\n", result);

    }
}
