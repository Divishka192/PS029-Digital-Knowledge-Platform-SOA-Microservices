package com.klu.repository;

import com.klu.entity.Content;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository
        extends JpaRepository<Content, Long> {

}