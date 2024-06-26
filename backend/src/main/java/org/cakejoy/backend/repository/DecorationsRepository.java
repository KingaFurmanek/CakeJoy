package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Decoration;
import org.cakejoy.backend.api.internal.DecorationsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DecorationsRepository extends JpaRepository<Decoration, Integer> {

    Decoration findDecorationByName(String name);
}
