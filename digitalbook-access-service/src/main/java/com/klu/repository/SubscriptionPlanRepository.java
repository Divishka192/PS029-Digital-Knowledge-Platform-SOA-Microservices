package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.SubscriptionPlan;

public interface SubscriptionPlanRepository
        extends JpaRepository<SubscriptionPlan, Long> {

}