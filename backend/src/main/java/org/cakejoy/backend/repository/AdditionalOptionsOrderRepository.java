package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.AdditionalOptionsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalOptionsOrderRepository extends JpaRepository<AdditionalOptionsOrder, Integer> {


}