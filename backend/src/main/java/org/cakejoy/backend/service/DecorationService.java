package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.DecorationDTO;
import org.cakejoy.backend.api.external.DecorationsOrderDTO;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Decoration;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DecorationService {
    void submitDecorations(OrdersDTO orderRequestDTO, Integer orderId);
}
