package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.CategoryDTO;
import org.cakejoy.backend.api.internal.Category;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

}
