package org.cakejoy.backend.controller;

import org.cakejoy.backend.api.external.*;
import lombok.NoArgsConstructor;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@NoArgsConstructor
public class UsersController {

    @GetMapping("/{userId}/address")
    public Address getUserAddress(@PathVariable Integer userId) {
        Address address = new Address()
                .setId(1)
                .setCountry("Poland")
                .setPostcode("00-001")
                .setCity("Warsaw")
                .setStreet("Main Street")
                .setNumber("123");

        Users user = new Users()
                .setId(userId)
                .setName("John")
                .setSurname("Doe")
                .setEmail("john.doe@example.com")
                .setImage("profile.jpg")
                .setAddress(address);

        address.setUser(user);

        return user.getAddress();

    }

    @PutMapping("/{userId}/address")
    public ResponseEntity<Object>editUserAddress(@PathVariable Integer userId, @RequestBody AddressDTO updatedAddress) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(200));
    }
}
