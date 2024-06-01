package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.external.ScoreDTO;
import org.cakejoy.backend.api.external.StateDTO;
import java.text.ParseException;
import java.util.List;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();
    Integer submitOrder(OrdersDTO orderRequestDTO) throws ParseException;
    OrdersDTO getOrderInfo(Integer orderId);
    String getOrderState(Integer orderId);
    void setOrderState(Integer orderId, StateDTO stateDTO);
    Integer getOrderScore(Integer orderId);
    void setOrderScore(Integer orderId, ScoreDTO scoreDTO);
    List<OrdersDTO> searchOrders(String query);
}
