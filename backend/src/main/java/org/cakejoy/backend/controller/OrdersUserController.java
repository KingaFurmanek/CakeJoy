package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersUserController {

    @GetMapping("/{userId}")
    public List<OrderUserDTO> getUserOrders(@PathVariable Integer userId) {

        OrderUserDTO orderUserDTO = new OrderUserDTO();
        orderUserDTO.setId(1);
        orderUserDTO.setOrderId(2);
        orderUserDTO.setUserId(userId);
        List<OrderUserDTO> userOrders = List.of(orderUserDTO);

        return userOrders;
    }


}

