package com.newlight77;

public class Calculator {

    public double calculate(double a, double b) {
        if (a < 0 || b < 0 ) {
            throw new IllegalArgumentException("invalid number");
        }
        return a + b;
    }
}
