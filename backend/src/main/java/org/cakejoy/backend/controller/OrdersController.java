package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final List<OrdersDTO> ordersList = new ArrayList<>();

    {
        CategoryDTO category = new CategoryDTO();
        category.setId(1);
        category.setName("cookies");

        FlavourDTO chocolateFlavour = new FlavourDTO();
        chocolateFlavour.setId(1);
        chocolateFlavour.setName("chocolate");

        AdditionalOptionsDTO icing = new AdditionalOptionsDTO();
        icing.setId(1);
        icing.setName("icing");

        OrderUserDTO customer = new OrderUserDTO();
        customer.setId(1);

        OrdersDTO order = new OrdersDTO();
        order.setId(1);
        order.setOccasion("Birthday");
        order.setQuantity(1.0);
        order.setTiers(1);
        order.setAdditionalInfo("None");
        order.setColours("Blue, Red");
        order.setDate(Date.valueOf(LocalDate.now()));
        order.setCategory(category);
        order.setState("Pending");
        order.setScore(0);
        order.getFlavours().add(chocolateFlavour);
        order.getAdditionalOptions().add(icing);
        order.getOrderUsers().add(customer);

        ordersList.add(order);
    }

    @GetMapping
    public List<OrdersDTO> getOrders() {
        return ordersList;
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrdersDTO order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(201));
    }
}
