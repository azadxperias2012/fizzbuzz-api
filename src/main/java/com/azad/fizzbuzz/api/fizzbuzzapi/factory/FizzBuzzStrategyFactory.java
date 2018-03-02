package com.azad.fizzbuzz.api.fizzbuzzapi.factory;

import com.azad.fizzbuzz.api.fizzbuzzapi.strategy.IFizzBuzzStrategy;
import com.azad.fizzbuzz.api.fizzbuzzapi.strategy.NegativeFizzBuzzStrategy;
import com.azad.fizzbuzz.api.fizzbuzzapi.strategy.PositiveFizzBuzzStrategy;

public class FizzBuzzStrategyFactory {
    public static IFizzBuzzStrategy getFizzBuzzStrategy(int limt) {
        IFizzBuzzStrategy fizzBuzzStrategy = null;
        if (limt > 0) {
            fizzBuzzStrategy = PositiveFizzBuzzStrategy.getInstance();
        } else {
            fizzBuzzStrategy = NegativeFizzBuzzStrategy.getInstance();
        }
        return fizzBuzzStrategy;
    }
}
