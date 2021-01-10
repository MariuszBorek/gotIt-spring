package com.gotit.controller;




import com.gotit.dto.CategoryDTO;
import com.gotit.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/home")
public class HomeController {

    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories", produces = "application/json")
    public List<CategoryDTO> validateLogin() {
        return categoryService.convertCategoryEntityToCategoryDTO(categoryService.findAllCategories());
    }




}
