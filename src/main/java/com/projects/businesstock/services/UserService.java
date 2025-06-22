package com.projects.businesstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.businesstock.domain.user.User;
import com.projects.businesstock.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}