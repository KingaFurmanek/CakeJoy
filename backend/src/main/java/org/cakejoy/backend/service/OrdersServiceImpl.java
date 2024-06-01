package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.*;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.mapper.*;
import org.cakejoy.backend.rabbitmq.NotificationProducer;
import org.cakejoy.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final UsersRepository usersRepository;
    private final OrderUserRepository orderUserRepository;
    private final NotificationProducer notificationProducer;

    @Override
    public List<OrdersDTO> getAllOrders() {
        return ordersRepository.findAllWithCategory().stream()
                .map(ordersMapper::map)
                .toList();
    }

    @Transactional
    public Integer submitOrder(OrdersDTO orderRequestDTO) throws ParseException {
        orderRequestDTO.setState("In preparation");
        Orders order = ordersMapper.map(orderRequestDTO);

        Users user = usersRepository.findById(orderRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        OrderUser orderUser = new OrderUser();
        orderUser.setOrder(order);
        orderUser.setUser(user);
        orderUserRepository.save(orderUser);

        Set<OrderUser> orderUsers = new HashSet<>();
        orderUsers.add(orderUser);
        order.setOrderUser(orderUsers);

        ordersRepository.save(order);

        return order.getId();
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
        Integer userId = orderUserRepository.findUserIdByOrderId(orderId);
        String userEmail = usersRepository.findUsersById(userId).getEmail();
        String stateStr = stateDTO.getState();
        String message = String.format("OrderId: %d, State: %s, UserEmail: %s", orderId, stateStr, userEmail);
        notificationProducer.sendNotification(message);
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
