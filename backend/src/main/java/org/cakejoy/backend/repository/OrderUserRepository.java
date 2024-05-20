package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.OrderUser;
import org.cakejoy.backend.api.internal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderUserRepository extends JpaRepository<OrderUser, Integer> {
    @Query("SELECT ou FROM OrderUser ou WHERE ou.user = :user")
    Set<OrderUser> findByUser(Users user);
}
