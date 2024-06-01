package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

import java.util.List;

public interface OrderUserService {
    List<OrdersDTO> getUserOrders(Integer userId);
}
