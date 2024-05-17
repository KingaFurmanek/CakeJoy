package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.internal.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByName(String name);
}