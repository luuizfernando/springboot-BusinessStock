package com.projects.businesstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.projects.businesstock.domain.user.User;


public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

}