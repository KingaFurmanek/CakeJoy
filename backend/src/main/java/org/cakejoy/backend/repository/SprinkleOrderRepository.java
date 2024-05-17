package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.GlazeOrder;
import org.cakejoy.backend.api.internal.SprinklesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SprinkleOrderRepository extends JpaRepository<SprinklesOrder, Integer> {

    List<SprinklesOrder> findByOrdersId(Integer orderId);
}
