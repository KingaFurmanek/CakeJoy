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
    private final DecorationService decorationsService;

    @GetMapping
    public List<OrdersDTO> getOrders() {
        return (ordersService.getAllOrders());
    }

//    @GetMapping("/{orderId}/decorations")
//    public ResponseEntity<List<DecorationDTO>> getOrderDecorations(@PathVariable Integer orderId) {
//        List<DecorationDTO> decorations = decorationsService.getDecorationsForOrder(orderId);
//        return ResponseEntity.ok(decorations);
//    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(@RequestBody OrdersDTO orderRequestDTO) {
        try {
            ordersService.submitOrder(orderRequestDTO);
            return ResponseEntity.ok("Order submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting order: " + e.getMessage());
        }

    }

}
