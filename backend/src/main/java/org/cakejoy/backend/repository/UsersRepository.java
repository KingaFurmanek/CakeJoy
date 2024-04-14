package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findUsersByEmail(String email);
}
