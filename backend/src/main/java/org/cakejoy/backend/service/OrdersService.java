package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Category;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();
//    Set<Decoration> getDecorationsForOrder(Integer orderId);
//    Category getCategoryForOrder(Integer orderId);
//    Integer getOrderId(Integer orderId);
    void submitOrder(OrdersDTO orderRequestDTO);
}
