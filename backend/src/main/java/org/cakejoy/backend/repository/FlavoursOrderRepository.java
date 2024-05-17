package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.FlavourOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlavoursOrderRepository extends JpaRepository<FlavourOrder, Integer> {

    List<FlavourOrder> findByOrderId(Integer orderId);
}
