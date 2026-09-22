package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.AccessLog;

public interface AccessLogRepository
        extends JpaRepository<AccessLog, Long> {

}