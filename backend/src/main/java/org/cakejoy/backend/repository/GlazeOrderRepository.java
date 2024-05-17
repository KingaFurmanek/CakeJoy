package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.DecorationsOrder;
import org.cakejoy.backend.api.internal.GlazeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlazeOrderRepository extends JpaRepository<GlazeOrder, Integer> {

    List<GlazeOrder> findByOrdersId(Integer orderId);
}
