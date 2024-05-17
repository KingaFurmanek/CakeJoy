package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.AdditionalOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalOptionsRepository extends JpaRepository<AdditionalOptions, Integer> {

    AdditionalOptions findAdditionalOptionsByName(String name);
}

