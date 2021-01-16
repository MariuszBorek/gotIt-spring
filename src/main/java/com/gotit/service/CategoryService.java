package com.gotit.service;

import com.gotit.dto.CategoryDTO;
import com.gotit.entity.Auction;
import com.gotit.entity.Category;
import com.gotit.entity.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<CategoryDTO> convertCategoryEntityToCategoryDTO(List<Category> category) {
        return List.of(new CategoryDTO("Electronics", "computers, laptops and mobile phone", "avatar"),
                new CategoryDTO("Fashion", "clothes and shoes", "avatar"),
                new CategoryDTO("Home and Garden", "furniture, bathroom, bedroom and tools", "avatar"),
                new CategoryDTO("Baby", "children's clothes and accessories", "avatar"),
                new CategoryDTO("Toys", "lego bricks, car toys and dolls", "avatar"),
                new CategoryDTO("Health", "cosmetics and perfumes", "avatar"),
                new CategoryDTO("Culture and Entertainment", "art, comics and antique", "avatar"),
                new CategoryDTO("Sporting goods", "cycling, fishing and fitness", "avatar"),
                new CategoryDTO("Motors", "cars, bikes and boats", "avatar"),
                new CategoryDTO("Estate", "houses and property", "avatar"),
                new CategoryDTO("Company and Services", "cleaning, manufacturing and office equipment", "avatar"));
    }



}


