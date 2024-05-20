package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Sprinkle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprinkleRepository extends JpaRepository<Sprinkle, Integer> {

    Sprinkle findSprinkleByName(String name);
}
