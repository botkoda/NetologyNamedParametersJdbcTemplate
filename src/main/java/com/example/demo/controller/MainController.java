package com.example.demo.controller;

import com.example.demo.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    MainService mainService;
    public MainController(MainService mainService) {
        this.mainService = mainService;

    }
    @GetMapping("products/fetch-product")
    public String getName(@RequestParam("name") String name){
        return mainService.getProductName(name);
    }
}
