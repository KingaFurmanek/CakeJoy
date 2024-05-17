package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.mapper.*;
import org.cakejoy.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final DecorationsOrderRepository decorationsOrderRepository;
    private final DecorationMapper decorationMapper;
    private final AdditionalOptionsMapper additionalOptionsMapper;
    private final AdditionalOptionsOrderRepository additionalOptionsOrderRepository;
    private final FlavoursOrderRepository flavourOrderRepository;
    private final FlavoursMapper flavourMapper;
    private final GlazeMapper glazeMapper;
    private final SprinkleMapper sprinkleMapper;
    private final GlazeOrderRepository glazeOrderRepository;
    private final SprinkleOrderRepository sprinkleOrderRepository;

    @Override
    public List<OrdersDTO> getAllOrders() {
        return ordersRepository.findAllWithCategory().stream()
                .map(ordersMapper::map)
                .toList();
    }

    @Transactional
    public void submitOrder(OrdersDTO orderRequestDTO) {
        Orders order = ordersMapper.map(orderRequestDTO);

        ordersRepository.save(order);

        Set<String> selectedDecoration = orderRequestDTO.getDecorations();
        Set<String> selectedAdditionalOptions = orderRequestDTO.getAdditionalOptions();
        Set<String> selectedFlavours = orderRequestDTO.getFlavours();
        Set<String> selectedGlazes = orderRequestDTO.getGlazes();
        Set<String> selectedSprinkles = orderRequestDTO.getSprinkles();

        if (!selectedDecoration.isEmpty()) {
            for (String decorationDTO : selectedDecoration) {
                DecorationsOrder decorationsOrder = new DecorationsOrder();
                Decoration decoration = decorationMapper.mapToEntity(decorationDTO);
                decorationsOrder.setOrders(order);
                decorationsOrder.setDecoration(decoration);
                decorationsOrderRepository.save(decorationsOrder);
            }
        }
        if (!selectedAdditionalOptions.isEmpty()) {
            for (String additionalOptionsDTO : selectedAdditionalOptions) {
                AdditionalOptionsOrder additionalOptionsOrder = new AdditionalOptionsOrder();
                AdditionalOptions additionalOptions = additionalOptionsMapper.mapToEntity(additionalOptionsDTO);
                additionalOptionsOrder.setOrder(order);
                additionalOptionsOrder.setAdditionalOptions(additionalOptions);
                additionalOptionsOrderRepository.save(additionalOptionsOrder);
            }
        }
        if (!selectedFlavours.isEmpty()) {
            for (String flavourDTO : selectedFlavours) {
                FlavourOrder flavourOrder = new FlavourOrder();
                Flavour flavour = flavourMapper.mapToEntity(flavourDTO);
                flavourOrder.setOrder(order);
                flavourOrder.setFlavour(flavour);
                flavourOrderRepository.save(flavourOrder);
            }
        }
        if (!selectedGlazes.isEmpty()) {
            for (String glazeDTO : selectedGlazes) {
                GlazeOrder glazeOrder = new GlazeOrder();
                Glaze glaze = glazeMapper.mapToEntity(glazeDTO);
                glazeOrder.setOrders(order);
                glazeOrder.setGlaze(glaze);
                glazeOrderRepository.save(glazeOrder);
            }
        }
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