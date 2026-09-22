package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.ReadingSession;

public interface ReadingSessionRepository
        extends JpaRepository<ReadingSession, Long> {

}