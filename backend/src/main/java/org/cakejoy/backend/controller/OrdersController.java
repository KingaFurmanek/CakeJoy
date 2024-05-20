package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.service.DecorationService;
import org.cakejoy.backend.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public List<OrdersDTO> getOrders() {
        return (ordersService.getAllOrders());
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(@RequestBody OrdersDTO orderRequestDTO) {
        try {
            ordersService.submitOrder(orderRequestDTO);
            return ResponseEntity.ok("Order submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting order: " + e.getMessage());
        }
    }

    @GetMapping("/{orderId}")
    public OrdersDTO getOrderInfo(@PathVariable Integer orderId) {
        return ordersService.getOrderInfo(orderId);
    }

    @GetMapping("/{orderId}/state")
    public String getOrderState(@PathVariable Integer orderId) {
        return ordersService.getOrderState(orderId);
    }

    @PostMapping("/{orderId}/state")
    public ResponseEntity<String> setOrderState(@PathVariable Integer orderId, @RequestBody StateDTO stateDTO) {
        try {
            ordersService.setOrderState(orderId, stateDTO);
            return ResponseEntity.ok("Order's state submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting state: " + e.getMessage());
        }
    }

    @GetMapping("/{orderId}/score")
    public Integer getOrderScore(@PathVariable Integer orderId) {
        return ordersService.getOrderScore(orderId);
    }

    @PostMapping("/{orderId}/score")
    public ResponseEntity<String> setOrderScore(@PathVariable Integer orderId, @RequestBody ScoreDTO scoreDTO) {
        try {
            ordersService.setOrderScore(orderId, scoreDTO);
            return ResponseEntity.ok("Order's score submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting score: " + e.getMessage());
        }
    }

}
