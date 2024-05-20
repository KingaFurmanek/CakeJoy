package org.cakejoy.backend.mapper;


import org.cakejoy.backend.api.internal.OrderUser;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.repository.OrdersRepository;
import org.cakejoy.backend.repository.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class OrderUserMapper {

    private final OrdersRepository orderRepository;
    private final UsersRepository usersRepository;

    public OrderUserMapper(OrdersRepository orderRepository, UsersRepository usersRepository) {
        this.orderRepository = orderRepository;
        this.usersRepository = usersRepository;
    }

    public Set<OrderUser> map(Integer orderId, Integer userId) {
        Orders order = orderRepository.findOrdersById(orderId);
        Users user = usersRepository.findUsersById(userId);

        Set<OrderUser> orderUsers = new HashSet<>();
        orderUsers.add(new OrderUser()
                .setOrder(order)
                .setUser(user));

        return orderUsers;
    }

    public Integer map(Set<OrderUser> orderUsers) {
        if (orderUsers.isEmpty()) {
            throw new NoSuchElementException("Brak elementów w zbiorze OrderUser");
        }
        OrderUser orderUser = orderUsers.iterator().next();
        return orderUser.getOrder().getId();
    }
}

