package com.projects.businesstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.businesstock.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {}