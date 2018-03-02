package com.azad.fizzbuzz.api.fizzbuzzapi.controller;

import com.azad.fizzbuzz.api.fizzbuzzapi.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzApiController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @GetMapping(value = "/api/{limit}")
    String getFizzBuzzResult(@PathVariable int limit) {
        String result = "0";
        if (limit != 0) {
            result =  fizzBuzzService.getResult(limit);
        }
        return result;
    }

}
