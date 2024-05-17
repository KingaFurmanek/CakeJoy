package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o JOIN FETCH o.category")
    List<Orders> findAllWithCategory();
}
