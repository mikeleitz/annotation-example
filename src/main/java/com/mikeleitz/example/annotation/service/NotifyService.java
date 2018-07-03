package com.mikeleitz.example.annotation.service;

import com.mikeleitz.example.annotation.annotation.SeverityEnum;

/**
 * @author Mike Leitz
 */
public interface NotifyService {
    void escalateToSupport(SeverityEnum severityEnum, String input, String result) ;
}
