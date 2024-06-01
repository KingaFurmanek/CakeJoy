package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

public interface GlazeService {
    void submitGlaze(OrdersDTO orderRequestDTO, Integer orderId);
}
