package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.mapper.AdditionalOptionsMapper;
import org.cakejoy.backend.repository.AdditionalOptionsOrderRepository;
import org.cakejoy.backend.repository.OrdersRepository;
import org.cakejoy.backend.service.AdditionalOptionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdditionalOptionsServiceImpl implements AdditionalOptionsService {

    private final AdditionalOptionsOrderRepository additionalOptionsOrderRepository;
    private final AdditionalOptionsMapper additionalOptionsMapper;
    private final OrdersRepository ordersRepository;

    @Transactional
    @Override
    public void submitAdditionalOptions(OrdersDTO orderRequestDTO, Integer orderId) {
        Orders order = ordersRepository.findOrdersById(orderId);
        Set<String> selectedAdditionalOptions = orderRequestDTO.getAdditionalOptions();

        if (!selectedAdditionalOptions.isEmpty()) {
            for (String additionalOptionsDTO : selectedAdditionalOptions) {
                AdditionalOptionsOrder additionalOptionsOrder = new AdditionalOptionsOrder();
                AdditionalOptions additionalOptions = additionalOptionsMapper.mapToEntity(additionalOptionsDTO);
                additionalOptionsOrder.setOrders(order);
                additionalOptionsOrder.setAdditionalOptions(additionalOptions);
                additionalOptionsOrderRepository.save(additionalOptionsOrder);
            }
        }
    }
}
