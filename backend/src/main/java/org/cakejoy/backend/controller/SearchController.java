package org.cakejoy.backend.controller;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final OrdersService ordersService;

    public SearchController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> searchOrders(@RequestParam("query") String query) {
        List<OrdersDTO> searchResults = ordersService.searchOrders(query);
        return ResponseEntity.ok().body(searchResults);
    }
}
