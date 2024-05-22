package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.mapper.*;
import org.cakejoy.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private final UsersRepository usersRepository;
    private final OrderUserRepository orderUserRepository;

    @Override
    public List<OrdersDTO> getAllOrders() {
        return ordersRepository.findAllWithCategory().stream()
                .map(ordersMapper::map)
                .toList();
    }

    @Transactional
    public void submitOrder(OrdersDTO orderRequestDTO) {
        orderRequestDTO.setState("In preparation");
        Orders order = ordersMapper.map(orderRequestDTO);

        ordersRepository.save(order);

        Users user = usersRepository.findById(orderRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        OrderUser orderUser = new OrderUser();
        orderUser.setOrder(order);
        orderUser.setUser(user);
        orderUserRepository.save(orderUser);

        Set<OrderUser> orderUsers = new HashSet<>();
        orderUsers.add(orderUser);
        order.setOrderUser(orderUsers);

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
                additionalOptionsOrder.setOrders(order);
                additionalOptionsOrder.setAdditionalOptions(additionalOptions);
                additionalOptionsOrderRepository.save(additionalOptionsOrder);
            }
        }
        if (!selectedFlavours.isEmpty()) {
            for (String flavourDTO : selectedFlavours) {
                FlavourOrder flavourOrder = new FlavourOrder();
                Flavour flavour = flavourMapper.mapToEntity(flavourDTO);
                flavourOrder.setOrders(order);
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

    @Override
    public OrdersDTO getOrderInfo(Integer orderId){
        Orders order = ordersRepository.findOrdersById(orderId);
        return ordersMapper.map(order);
    }

    @Override
    public String getOrderState(Integer orderId){
        Orders orders = ordersRepository.findOrdersById(orderId);
        return orders.getState();
    }

    @Override
    public void setOrderState(Integer orderId, StateDTO stateDTO) {
        ordersRepository.updateOrderState(orderId, stateDTO.getState());
    }

    @Override
    public Integer getOrderScore(Integer orderId) {
        Orders orders = ordersRepository.findOrdersById(orderId);
        return orders.getScore();
    }

    @Override
    public void setOrderScore(Integer orderId, ScoreDTO scoreDTO) {
        ordersRepository.updateOrderScore(orderId, scoreDTO.getScore());
    }

    @Override
    public List<OrdersDTO> searchOrders(String query) {
        List<Orders> searchResults = ordersRepository.findByIdContainingOrCategory_NameContaining(query);
        return searchResults.stream()
                .map(ordersMapper::map)
                .collect(Collectors.toList());
    }
}
