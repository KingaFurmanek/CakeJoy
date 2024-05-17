package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Sprinkle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprinkleRepository extends JpaRepository<Sprinkle, Integer> {

    Sprinkle findSprinkleByName(String name);
}
