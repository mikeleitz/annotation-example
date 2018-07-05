package com.mikeleitz.example.service;

import com.mikeleitz.example.annotation.SeverityEnum;

/**
 * @author Mike Leitz
 */
public interface NotifyService {
    void escalateToSupport(SeverityEnum severityEnum, String input, String result) ;
}
