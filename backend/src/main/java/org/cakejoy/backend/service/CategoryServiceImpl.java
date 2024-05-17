package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.CategoryDTO;
import org.cakejoy.backend.api.internal.Category;
import org.cakejoy.backend.mapper.CategoryMapper;
import org.cakejoy.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
    }

}
