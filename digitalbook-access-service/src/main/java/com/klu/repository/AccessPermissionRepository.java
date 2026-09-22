package com.klu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.AccessPermission;

public interface AccessPermissionRepository
        extends JpaRepository<AccessPermission, Long> {

    Optional<AccessPermission>
    findByUserIdAndContentId(
            Long userId,
            Long contentId
    );
}