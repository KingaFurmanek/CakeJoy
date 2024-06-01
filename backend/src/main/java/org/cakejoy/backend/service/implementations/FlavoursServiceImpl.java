package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Flavour;
import org.cakejoy.backend.api.internal.FlavourOrder;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.mapper.FlavoursMapper;
import org.cakejoy.backend.repository.FlavoursOrderRepository;
import org.cakejoy.backend.repository.OrdersRepository;
import org.cakejoy.backend.service.FlavoursService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlavoursServiceImpl implements FlavoursService {

    private final OrdersRepository ordersRepository;
    private final FlavoursOrderRepository flavourOrderRepository;
    private final FlavoursMapper flavourMapper;

    @Transactional
    @Override
    public void submitFlavours(OrdersDTO orderRequestDTO, Integer orderId) {
        Orders order = ordersRepository.findOrdersById(orderId);
        Set<String> selectedFlavours = orderRequestDTO.getFlavours();

        if (!selectedFlavours.isEmpty()) {
            for (String flavourDTO : selectedFlavours) {
                FlavourOrder flavourOrder = new FlavourOrder();
                Flavour flavour = flavourMapper.mapToEntity(flavourDTO);
                flavourOrder.setOrders(order);
                flavourOrder.setFlavour(flavour);
                flavourOrderRepository.save(flavourOrder);
            }
        }
    }
}
