package com.example.codingbat.controller;

import com.example.codingbat.entity.ProgrammingLang;
import com.example.codingbat.payload.ApiResponse;
import com.example.codingbat.repositories.ProgrammiingLangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgrammingLangController {
    @Autowired
    ProgrammiingLangRepository programmiingLangRepository;
    @PostMapping
      public ApiResponse addpr(@RequestBody ProgrammingLang programmingLang){
        ProgrammingLang programmingLang1=new ProgrammingLang();
        programmingLang1.setId(programmingLang.getId());

        programmiingLangRepository.save(programmingLang1);
        return new ApiResponse("successfully",true);
    }

    @GetMapping
    public List<ProgrammingLang> getPr(){
      return   programmiingLangRepository.findAll();
    }






}
