package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.OrderUser;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.OrdersMapper;
import org.cakejoy.backend.repository.OrderUserRepository;
import org.cakejoy.backend.repository.UsersRepository;
import org.cakejoy.backend.service.OrderUserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderUserServiceImpl implements OrderUserService {

    private final UsersRepository usersRepository;
    private final OrderUserRepository orderUserRepository;
    private final OrdersMapper ordersMapper;

    @Override
    public List<OrdersDTO> getUserOrders(Integer userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        List<OrderUser> orderUsers = orderUserRepository.findByUser(user);

        return orderUsers.stream()
                .map(orderUser -> {
                    Orders order = orderUser.getOrder();
                    return ordersMapper.map(order);
                })
                .collect(Collectors.toList());
    }
}
