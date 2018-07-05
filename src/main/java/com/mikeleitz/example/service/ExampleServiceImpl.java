package com.mikeleitz.example.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author Mike Leitz
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    private Logger _logger = LoggerFactory.getLogger(ExampleServiceImpl.class);

    @Override
    public String reverseMyInput(String input) {
        return StringUtils.reverse(input);
    }
}
