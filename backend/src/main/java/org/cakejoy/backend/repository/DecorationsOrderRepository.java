package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.DecorationsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecorationsOrderRepository extends JpaRepository<DecorationsOrder, Integer> {

    List<DecorationsOrder> findByOrdersId(Integer orderId);
}
