package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.external.ScoreDTO;
import org.cakejoy.backend.api.external.StateDTO;
import org.cakejoy.backend.api.internal.Category;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();
    void submitOrder(OrdersDTO orderRequestDTO);
    OrdersDTO getOrderInfo(Integer orderId);
    String getOrderState(Integer orderId);
    void setOrderState(Integer orderId, StateDTO stateDTO);
    Integer getOrderScore(Integer orderId);
    void setOrderScore(Integer orderId, ScoreDTO scoreDTO);
    List<OrdersDTO> searchOrders(String query);
}
