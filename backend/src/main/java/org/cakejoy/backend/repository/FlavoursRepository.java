package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Flavour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavoursRepository extends JpaRepository<Flavour, Integer> {

    Flavour findFlavourByName(String name);
}

