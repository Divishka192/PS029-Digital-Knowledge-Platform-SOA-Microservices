package com.klu.service;

import org.springframework.stereotype.Service;

import com.klu.entity.AccessLog;
import com.klu.entity.ReadingHistory;
import com.klu.entity.ReadingSession;

import com.klu.repository.AccessLogRepository;
import com.klu.repository.ReadingHistoryRepository;
import com.klu.repository.ReadingSessionRepository;

@Service
public class UsageService {

    private final ReadingSessionRepository sessionRepository;

    private final ReadingHistoryRepository historyRepository;

    private final AccessLogRepository logRepository;

    public UsageService(
            ReadingSessionRepository sessionRepository,
            ReadingHistoryRepository historyRepository,
            AccessLogRepository logRepository) {

        this.sessionRepository = sessionRepository;

        this.historyRepository = historyRepository;

        this.logRepository = logRepository;
    }

    public ReadingSession saveSession(
            ReadingSession session) {

        return sessionRepository.save(session);
    }

    public ReadingHistory saveHistory(
            ReadingHistory history) {

        return historyRepository.save(history);
    }

    public AccessLog saveLog(
            AccessLog log) {

        return logRepository.save(log);
    }
}