package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.AdditionalOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalOptionsRepository extends JpaRepository<AdditionalOptions, Integer> {

    AdditionalOptions findAdditionalOptionsByName(String name);
}

