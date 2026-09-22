package com.klu.controller;

import org.springframework.web.bind.annotation.*;

import com.klu.entity.AccessPermission;
import com.klu.entity.SubscriptionPlan;
import com.klu.entity.UserSubscription;

import com.klu.service.AccessService;

@RestController
@RequestMapping("/access")
public class AccessController {

    private final AccessService service;

    public AccessController(
            AccessService service) {

        this.service = service;
    }

    @PostMapping("/plan")
    public SubscriptionPlan addPlan(
            @RequestBody SubscriptionPlan plan) {

        return service.addPlan(plan);
    }

    @PostMapping("/subscribe")
    public UserSubscription subscribe(
            @RequestBody UserSubscription subscription) {

        return service.subscribe(subscription);
    }

    @PostMapping("/grant")
    public AccessPermission grant(
            @RequestBody AccessPermission permission) {

        return service.grantPermission(permission);
    }

    @GetMapping("/check")
    public String check(
            @RequestParam Long userId,
            @RequestParam Long contentId) {

        return service.checkAccess(
                userId,
                contentId
        );
    }
}