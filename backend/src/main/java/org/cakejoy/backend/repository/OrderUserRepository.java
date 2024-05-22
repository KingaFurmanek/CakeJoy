package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.OrderUser;
import org.cakejoy.backend.api.internal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderUserRepository extends JpaRepository<OrderUser, Integer> {
    @Query("SELECT ou FROM OrderUser ou JOIN FETCH ou.order o WHERE ou.user = :user ORDER BY o.id DESC")
    List<OrderUser> findByUser(@Param("user") Users user);
}
