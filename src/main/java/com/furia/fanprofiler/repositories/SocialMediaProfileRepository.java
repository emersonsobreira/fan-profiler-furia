package com.furia.fanprofiler.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furia.fanprofiler.models.SocialMediaProfile;

@Repository
public interface SocialMediaProfileRepository extends JpaRepository<SocialMediaProfile, UUID> {
}
