package com.furia.fanprofiler.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furia.fanprofiler.models.Fan;

@Repository
public interface FanRepository extends JpaRepository<Fan, UUID> {

    Fan findByCpf(String cpf);

    Fan findByEmail(String email);
}
