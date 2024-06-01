package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.OrdersMapper;
import org.cakejoy.backend.service.OrderUserService;
import org.cakejoy.backend.service.OrdersService;
import org.cakejoy.backend.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderUserController {

    private final UsersService usersService;
    private final OrderUserService orderUserService;

    @GetMapping("/user")
    public ResponseEntity<List<OrdersDTO>> getUserOrders(Authentication authentication) {
        Users currentUser = (Users) authentication.getPrincipal();
        String userEmail = currentUser.getEmail();
        UsersDTO userDTO = usersService.getUserByEmail(userEmail);
        if (userDTO != null) {
            return ResponseEntity.ok(orderUserService.getUserOrders(userDTO.getId()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}



