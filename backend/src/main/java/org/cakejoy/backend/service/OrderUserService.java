package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;

import java.util.List;
import java.util.Set;

public interface OrderUserService {
    Set<OrdersDTO> getUserOrders(Integer userId);
}
