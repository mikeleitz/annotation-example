package com.mikeleitz.example.annotation.service;

import com.mikeleitz.example.annotation.annotation.SeverityEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author Mike Leitz
 */
@Service
public class NotifyServiceImpl implements NotifyService {
    private Logger _logger = LoggerFactory.getLogger(NotifyServiceImpl.class);

    @Override
    public void escalateToSupport(SeverityEnum severityEnum, String input, String result) {
        _logger.info("Letting support know that message [{}] has severity [{}] with result [{}].", input, severityEnum, result);

        /*
            Add code to let someone know this was high severity.
         */
    }
}
