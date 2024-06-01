package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Glaze;
import org.cakejoy.backend.api.internal.GlazeOrder;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.mapper.GlazeMapper;
import org.cakejoy.backend.repository.GlazeOrderRepository;
import org.cakejoy.backend.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GlazeServiceImpl implements GlazeService{

    private final GlazeOrderRepository glazeOrderRepository;
    private final GlazeMapper glazeMapper;
    private final OrdersRepository ordersRepository;

    @Override
    public void submitGlaze(OrdersDTO orderRequestDTO, Integer orderId) {
        Orders order = ordersRepository.findOrdersById(orderId);
        Set<String> selectedGlazes = orderRequestDTO.getGlazes();

        if (!selectedGlazes.isEmpty()) {
            for (String glazeDTO : selectedGlazes) {
                GlazeOrder glazeOrder = new GlazeOrder();
                Glaze glaze = glazeMapper.mapToEntity(glazeDTO);
                glazeOrder.setOrders(order);
                glazeOrder.setGlaze(glaze);
                glazeOrderRepository.save(glazeOrder);
            }
        }
    }
}
