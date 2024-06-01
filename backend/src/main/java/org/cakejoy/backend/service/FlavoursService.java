package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

public interface FlavoursService {
    void submitFlavours(OrdersDTO orderRequestDTO, Integer orderId);
}
