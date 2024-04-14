package org.cakejoy.backend.controller;

import org.cakejoy.backend.api.external.DecorationDTO;
import org.cakejoy.backend.api.external.DecorationsOrderDTO;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.external.ResponseDTO;
import org.cakejoy.backend.api.internal.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/decorations-order")
public class DecorationsOrderController {

    @GetMapping("/{orderId}")
    public Set<DecorationDTO> getDecorationsForOrder(@PathVariable Integer orderId) {

        OrdersDTO orderDTO = new OrdersDTO();
        orderDTO.setId(orderId);

        Set<DecorationDTO> decorations = new HashSet<>();
        decorations.add(new DecorationDTO().setId(1).setName("Flowers"));
        decorations.add(new DecorationDTO().setId(2).setName("Stars"));
        decorations.add(new DecorationDTO().setId(3).setName("Ribbons"));

        orderDTO.setDecoration(decorations);

        return orderDTO.getDecoration();
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<Object> addDecorationToOrder(@PathVariable Integer orderId, @RequestBody Set<DecorationDTO> decorations) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(201));
    }
}

