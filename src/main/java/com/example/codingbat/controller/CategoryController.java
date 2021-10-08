package com.example.codingbat.controller;

import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.ProgrammingLang;
import com.example.codingbat.payload.ApiResponse;
import com.example.codingbat.payload.CategoryDTO;
import com.example.codingbat.repositories.CategoryRepository;
import com.example.codingbat.repositories.ProgrammiingLangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProgrammiingLangRepository programmiingLangRepository;
    @PostMapping
    public ApiResponse addCategory(@RequestBody CategoryDTO categoryDTO){
        Category  category=new Category();
        category.setName(categoryDTO.getName());
        ProgrammingLang programmingLang=new ProgrammingLang();
        Optional<ProgrammingLang> byId = programmiingLangRepository.findById(categoryDTO.getProgrammingLangId());
        if (!byId.isPresent()) return new ApiResponse("not found",false);

        category.setProgrammingLang(byId.get());
        categoryRepository.save(category);
        return new ApiResponse("successfully",true);

    }@GetMapping
    public List<Category> getCategory(){
      return   categoryRepository.findAll();
    }

}
