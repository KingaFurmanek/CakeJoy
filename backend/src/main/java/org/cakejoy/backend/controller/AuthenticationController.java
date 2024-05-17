package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.AuthenticationRequest;
import org.cakejoy.backend.api.external.AuthenticationResponse;
import org.cakejoy.backend.api.external.RegisterRequest;
import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/verify")
    public ResponseEntity<UsersDTO> verify() {
        return ResponseEntity.ok(authService.verify());
    }

}
