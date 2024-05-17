package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByUser(Users users);
}
