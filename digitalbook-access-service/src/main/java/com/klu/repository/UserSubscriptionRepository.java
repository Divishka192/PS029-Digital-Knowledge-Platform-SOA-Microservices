package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.UserSubscription;

public interface UserSubscriptionRepository
        extends JpaRepository<UserSubscription, Long> {

}