package com.github.pwnmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ThingsRepository extends JpaRepository<ThingEntity, UUID> {

    Optional<ThingEntity> findByName(String name);
}
