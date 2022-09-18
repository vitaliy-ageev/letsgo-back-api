package com.letsgo.serviceapi.service;

import java.util.List;

import com.letsgo.serviceapi.model.AppRole;
import com.letsgo.serviceapi.model.AppUser;

public interface UserService {
    AppUser saveUser(AppUser user);

    AppRole saveRole(AppRole role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
