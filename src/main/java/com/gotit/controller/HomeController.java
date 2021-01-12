package com.gotit.controller;




import com.gotit.dto.AuctionDTO;
import com.gotit.dto.CategoryDTO;
import com.gotit.service.AuctionService;
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
    private final AuctionService auctionService;

    public HomeController(CategoryService categoryService, AuctionService auctionService) {
        this.categoryService = categoryService;
        this.auctionService = auctionService;
    }

    @GetMapping(path = "/categories", produces = "application/json")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.convertCategoryEntityToCategoryDTO(categoryService.findAllCategories());
    }






}
