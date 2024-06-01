package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

public interface AdditionalOptionsService {
    void submitAdditionalOptions(OrdersDTO orderRequestDTO, Integer orderId);
}
