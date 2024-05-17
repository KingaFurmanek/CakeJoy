package org.cakejoy.backend.controller;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.external.ResponseDTO;
import org.cakejoy.backend.api.external.SprinkleDTO;
import org.cakejoy.backend.api.external.SprinklesOrderDTO;
import org.cakejoy.backend.api.internal.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/sprinkles-order")
public class SprinkleOrderController {

//    @GetMapping("/{orderId}")
//    public Set<SprinkleDTO> getSprinklesForOrder(@PathVariable Integer orderId) {
//
//        Set<SprinkleDTO> sprinkles = new HashSet<>();
//        sprinkles.add(new SprinkleDTO().setId(1).setName("Chocolate chips"));
//        sprinkles.add(new SprinkleDTO().setId(2).setName("Rainbow sprinkles"));
//        sprinkles.add(new SprinkleDTO().setId(3).setName("Sugar crystals"));
//
//        OrdersDTO orderDTO = new OrdersDTO();
//        orderDTO.setId(orderId);
//
//        orderDTO.setSprinkles(sprinkles);
//
//        return orderDTO.getSprinkles();
//    }

    @PostMapping("/{orderId}")
    public ResponseEntity<Object> addSprinkleToOrder(@PathVariable Integer orderId, @RequestBody Set<SprinkleDTO> sprinkles) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(201));
    }
}
