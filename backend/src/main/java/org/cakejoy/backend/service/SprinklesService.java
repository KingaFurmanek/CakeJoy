package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

public interface SprinklesService {
    void submitSprinkles(OrdersDTO orderRequestDTO, Integer orderId);
}
