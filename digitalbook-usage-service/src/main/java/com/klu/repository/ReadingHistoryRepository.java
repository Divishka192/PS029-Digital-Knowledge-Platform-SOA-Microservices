package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.ReadingHistory;

public interface ReadingHistoryRepository
        extends JpaRepository<ReadingHistory, Long> {

}