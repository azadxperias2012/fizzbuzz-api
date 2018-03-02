package com.azad.fizzbuzz.api.fizzbuzzapi.service;

import com.azad.fizzbuzz.api.fizzbuzzapi.factory.FizzBuzzStrategyFactory;
import com.azad.fizzbuzz.api.fizzbuzzapi.strategy.IFizzBuzzStrategy;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
    public String getResult(int limit) {
        if (limit == 0) {
            return "0";
        }
        IFizzBuzzStrategy fizzBuzzStrategy = FizzBuzzStrategyFactory.getFizzBuzzStrategy(limit);
        return fizzBuzzStrategy.getResult(limit);
    }
}
