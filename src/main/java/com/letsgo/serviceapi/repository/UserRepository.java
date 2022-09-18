package com.letsgo.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsgo.serviceapi.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
