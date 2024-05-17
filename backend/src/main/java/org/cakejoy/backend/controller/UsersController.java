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
public class UsersController {

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

    @GetMapping("/info")
    public ResponseEntity<UsersDTO> getUserInfo(Authentication authentication) {
        Users currentUser = (Users) authentication.getPrincipal();
        String userEmail = currentUser.getEmail();
        UsersDTO userDTO = usersService.getUserByEmail(userEmail);
        if (userDTO != null) {
            return ResponseEntity.ok(usersService.getUserByEmail(userDTO.getEmail()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}/address")
    public ResponseEntity<Object> editUserAddress(@PathVariable Integer userId, @RequestBody AddressDTO updatedAddress) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(200));
    }
}

