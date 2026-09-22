package com.klu.controller;

import org.springframework.web.bind.annotation.*;

import com.klu.entity.AccessLog;
import com.klu.entity.ReadingHistory;
import com.klu.entity.ReadingSession;

import com.klu.service.UsageService;

@RestController
@RequestMapping("/usage")
public class UsageController {

    private final UsageService service;

    public UsageController(
            UsageService service) {

        this.service = service;
    }

    @PostMapping("/session")
    public ReadingSession saveSession(
            @RequestBody ReadingSession session) {

        return service.saveSession(session);
    }

    @PostMapping("/history")
    public ReadingHistory saveHistory(
            @RequestBody ReadingHistory history) {

        return service.saveHistory(history);
    }

    @PostMapping("/log")
    public AccessLog saveLog(
            @RequestBody AccessLog log) {

        return service.saveLog(log);
    }
}