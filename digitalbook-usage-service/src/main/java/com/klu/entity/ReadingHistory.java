package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reading_history")
public class ReadingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long contentId;

    private String lastAccessed;

    private double progressPercent;

    public ReadingHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(String lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public double getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(
            double progressPercent) {

        this.progressPercent = progressPercent;
    }
}