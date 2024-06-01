package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.mapper.DecorationMapper;
import org.cakejoy.backend.repository.DecorationsOrderRepository;
import org.cakejoy.backend.repository.OrdersRepository;
import org.cakejoy.backend.service.DecorationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DecorationServiceImpl implements DecorationService {

    private final DecorationsOrderRepository decorationsOrderRepository;
    private final DecorationMapper decorationMapper;
    private final OrdersRepository ordersRepository;

    @Transactional
    @Override
    public void submitDecorations(OrdersDTO orderRequestDTO, Integer orderId) {
        Orders order = ordersRepository.findOrdersById(orderId);
        Set<String> selectedDecoration = orderRequestDTO.getDecorations();

        if (!selectedDecoration.isEmpty()) {
            for (String decorationDTO : selectedDecoration) {
                DecorationsOrder decorationsOrder = new DecorationsOrder();
                Decoration decoration = decorationMapper.mapToEntity(decorationDTO);
                decorationsOrder.setOrders(order);
                decorationsOrder.setDecoration(decoration);
                decorationsOrderRepository.save(decorationsOrder);
            }
        }
    }
}
