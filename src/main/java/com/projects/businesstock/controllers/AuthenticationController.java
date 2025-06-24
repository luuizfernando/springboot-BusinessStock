package com.projects.businesstock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.businesstock.domain.user.AuthenticationDTO;
import com.projects.businesstock.domain.user.LoginResponseDTO;
import com.projects.businesstock.domain.user.RegisterDTO;
import com.projects.businesstock.domain.user.User;
import com.projects.businesstock.infra.security.TokenService;
import com.projects.businesstock.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("auth") 
@Tag(name = "authentication", description = "Controller to register an user and login to get authenticated")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "User login", description = "Method for a user with a created account to log in")
    @ApiResponse(responseCode = "200", description = "Login succeded")
    @ApiResponse(responseCode = "400", description = "Data sent in the request body is invalid")
    @ApiResponse(responseCode = "401", description = "Invalid credentials provided")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "User register", description = "Method for a user to create an account and authenticate to the system")
    @ApiResponse(responseCode = "201", description = "Account created")
    @ApiResponse(responseCode = "409", description = "Data sent in the request body is invalid")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
    
}