package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.service.JwtService;
import org.cakejoy.backend.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AddressController {

    private final UsersService usersService;
    private final JwtService jwtService;

    @GetMapping("/address")
    public ResponseEntity<AddressDTO> getUserAddress(Authentication authentication) {
        Users currentUser = (Users) authentication.getPrincipal();
        String userEmail = currentUser.getEmail();
        UsersDTO userDTO = usersService.getUserByEmail(userEmail);
        if (userDTO != null) {
            return ResponseEntity.ok(usersService.getUserAddress(userDTO.getId()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/address")
    public ResponseEntity<String> editUserAddress(Authentication authentication, @RequestBody AddressDTO updatedAddress) {
        Users currentUser = (Users) authentication.getPrincipal();
        String userEmail = currentUser.getEmail();
        UsersDTO userDTO = usersService.getUserByEmail(userEmail);
        if (userDTO != null) {
            boolean success = usersService.editUserAddress(userEmail, updatedAddress);
            if (success) {
                return ResponseEntity.ok("Address updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

