package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.api.internal.Sprinkle;
import org.cakejoy.backend.api.internal.SprinklesOrder;
import org.cakejoy.backend.mapper.SprinkleMapper;
import org.cakejoy.backend.repository.OrdersRepository;
import org.cakejoy.backend.repository.SprinkleOrderRepository;
import org.cakejoy.backend.service.SprinklesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SprinklesServiceImpl implements SprinklesService {

    private final OrdersRepository ordersRepository;
    private final SprinkleMapper sprinkleMapper;
    private final SprinkleOrderRepository sprinkleOrderRepository;

    @Override
    public void submitSprinkles(OrdersDTO orderRequestDTO, Integer orderId) {
        Orders order = ordersRepository.findOrdersById(orderId);
        Set<String> selectedSprinkles = orderRequestDTO.getSprinkles();

        if (!selectedSprinkles.isEmpty()) {
            for (String sprinkleDTO : selectedSprinkles) {
                SprinklesOrder sprinkleOrder = new SprinklesOrder();
                Sprinkle sprinkle = sprinkleMapper.mapToEntity(sprinkleDTO);
                sprinkleOrder.setOrders(order);
                sprinkleOrder.setSprinkle(sprinkle);
                sprinkleOrderRepository.save(sprinkleOrder);
            }
        }
    }
}
