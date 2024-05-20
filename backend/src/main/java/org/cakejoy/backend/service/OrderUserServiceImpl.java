package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.OrderUser;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.OrderUserMapper;
import org.cakejoy.backend.mapper.OrdersMapper;
import org.cakejoy.backend.repository.OrderUserRepository;
import org.cakejoy.backend.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderUserServiceImpl implements OrderUserService {

    private final OrdersService ordersService;
    private final OrderUserMapper orderUserMapper;
    private final UsersRepository usersRepository;
    private final OrderUserRepository orderUserRepository;
    private final OrdersMapper ordersMapper;

    @Override
    public Set<OrdersDTO> getUserOrders(Integer userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Set<OrderUser> orderUsers = orderUserRepository.findByUser(user);

        return orderUsers.stream()
                .map(orderUser -> {
                    Orders order = orderUser.getOrder();
                    return ordersMapper.map(order);
                })
                .collect(Collectors.toSet());
    }
}
