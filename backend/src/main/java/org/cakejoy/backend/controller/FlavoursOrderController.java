package org.cakejoy.backend.controller;

import org.cakejoy.backend.api.external.FlavourDTO;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.external.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/flavours-order")
public class FlavoursOrderController {

//    @GetMapping("/{orderId}")
//    public Set<FlavourDTO> getFlavoursForOrder(@PathVariable Integer orderId) {
//        Set<FlavourDTO> flavours = new HashSet<>();
//        flavours.add(new FlavourDTO().setId(1).setName("Chocolate"));
//        flavours.add(new FlavourDTO().setId(2).setName("Lemon "));
//
//        OrdersDTO orderDTO = new OrdersDTO();
//        orderDTO.setId(orderId);
//
//        orderDTO.setFlavours(flavours);
//
//        return orderDTO.getFlavours();
//    }

    @PostMapping("/{orderId}")
    public ResponseEntity<Object> addSFlavoursToOrder(@PathVariable Integer orderId, @RequestBody Set<FlavourDTO> flavours) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(201));
    }
}
