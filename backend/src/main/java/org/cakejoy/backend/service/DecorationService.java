package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

public interface DecorationService {
    void submitDecorations(OrdersDTO orderRequestDTO, Integer orderId);
}
