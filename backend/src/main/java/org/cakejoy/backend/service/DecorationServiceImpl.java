package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.DecorationDTO;
import org.cakejoy.backend.api.external.DecorationsOrderDTO;
import org.cakejoy.backend.api.internal.DecorationsOrder;
import org.cakejoy.backend.mapper.DecorationMapper;
import org.cakejoy.backend.repository.DecorationsOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DecorationServiceImpl implements DecorationService {

    private final DecorationsOrderRepository decorationsOrderRepository;
    private final DecorationMapper decorationMapper;

//    @Override
//    public List<DecorationDTO> getDecorationsForOrder(Integer orderId) {
//        List<DecorationsOrder> decorationsOrders = decorationsOrderRepository.findByOrdersId(orderId);
//        return decorationMapper.mapToDTOList(decorationsOrders);
//    }


}
