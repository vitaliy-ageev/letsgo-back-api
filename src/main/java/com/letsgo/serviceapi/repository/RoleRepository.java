package com.letsgo.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsgo.serviceapi.model.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
