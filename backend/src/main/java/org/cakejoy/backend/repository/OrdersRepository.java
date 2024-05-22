package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o JOIN FETCH o.category ORDER BY o.id DESC")
    List<Orders> findAllWithCategory();

    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.state = :state WHERE o.id = :orderId")
    void updateOrderState(@Param("orderId") Integer orderId, @Param("state") String state);

    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.score = :score WHERE o.id = :orderId")
    void updateOrderScore(@Param("orderId") Integer orderId, @Param("score") Integer score);

    Orders findOrdersById(Integer orderId);

    @Query("SELECT o FROM Orders o WHERE CAST(o.id AS string)=:query OR o.category.name=:query")
    List<Orders> findByIdContainingOrCategory_NameContaining(@Param("query") String query);
}
