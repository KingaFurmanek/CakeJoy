package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Flavour;
import org.cakejoy.backend.api.internal.Glaze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlazeRepository extends JpaRepository<Glaze, Integer> {

    Glaze findGlazeByName(String name);
}