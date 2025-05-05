package com.furia.fanprofiler.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furia.fanprofiler.models.Fan;

public interface FanRepository extends JpaRepository<Fan, UUID> {
}
