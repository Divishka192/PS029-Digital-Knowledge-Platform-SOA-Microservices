package com.klu.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.klu.entity.AccessPermission;
import com.klu.entity.SubscriptionPlan;
import com.klu.entity.UserSubscription;

import com.klu.repository.AccessPermissionRepository;
import com.klu.repository.SubscriptionPlanRepository;
import com.klu.repository.UserSubscriptionRepository;

@Service
public class AccessService {

    private final SubscriptionPlanRepository planRepository;

    private final UserSubscriptionRepository subscriptionRepository;

    private final AccessPermissionRepository permissionRepository;

    public AccessService(
            SubscriptionPlanRepository planRepository,
            UserSubscriptionRepository subscriptionRepository,
            AccessPermissionRepository permissionRepository) {

        this.planRepository = planRepository;

        this.subscriptionRepository =
                subscriptionRepository;

        this.permissionRepository =
                permissionRepository;
    }

    public SubscriptionPlan addPlan(
            SubscriptionPlan plan) {

        return planRepository.save(plan);
    }

    public UserSubscription subscribe(
            UserSubscription subscription) {

        subscription.setStatus("ACTIVE");

        return subscriptionRepository.save(subscription);
    }

    public AccessPermission grantPermission(
            AccessPermission permission) {

        permission.setPermissionType("READ");

        return permissionRepository.save(permission);
    }

    public String checkAccess(
            Long userId,
            Long contentId) {

        Optional<AccessPermission> permission =
                permissionRepository
                    .findByUserIdAndContentId(
                        userId,
                        contentId
                    );

        if (permission.isPresent()) {

            return "ACCESS GRANTED";
        }

        return "ACCESS DENIED";
    }
}