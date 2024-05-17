package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.internal.Category;
import org.cakejoy.backend.api.external.CategoryDTO;
import org.cakejoy.backend.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    private final CategoryRepository categoryRepository;

    public CategoryMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO map(Category category) {
        return new CategoryDTO()
                .setName(category.getName());
    }

    public Category map(String categoryDTO) {
        return categoryRepository.findCategoryByName(categoryDTO);
    }

}
