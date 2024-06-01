package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;
    private final DecorationService decorationService;
    private final AdditionalOptionsService additionalOptionsService;
    private final SprinklesService sprinklesService;
    private final FlavoursService flavoursService;
    private final GlazeService glazeService;


    @GetMapping
    public List<OrdersDTO> getOrders() {
        return (ordersService.getAllOrders());
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(Authentication authentication,@RequestBody OrdersDTO orderRequestDTO) {
        Users currentUser = (Users) authentication.getPrincipal();
        Integer userId = currentUser.getId();
        orderRequestDTO.setUserId(userId);
        try {
            Integer orderId =  ordersService.submitOrder(orderRequestDTO);
            decorationService.submitDecorations(orderRequestDTO, orderId);
            additionalOptionsService.submitAdditionalOptions(orderRequestDTO, orderId);
            flavoursService.submitFlavours(orderRequestDTO, orderId);
            sprinklesService.submitSprinkles(orderRequestDTO, orderId);
            glazeService.submitGlaze(orderRequestDTO, orderId);
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
