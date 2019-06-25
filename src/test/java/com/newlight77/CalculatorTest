package com.newlight77;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Calculator calculator = new Calculator();

    @Test
    public void exp_should_throw_exception_when_calculating_invalid_arguments_using_try_catch_exception(){
        try {
            calculator.calculate(-10, 10);
        }catch(IllegalArgumentException ex){
            assert(ex.getMessage().contains("invalid number"));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit_expected_exception() {
        calculator.calculate(-10, 10);
    }

    @Test
    public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit_rule(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid number");
        calculator.calculate(-10, 10);
    }

    @Test
    public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit5(){
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculate(-10, 10)
        );
        Assertions.assertEquals("invalid number", exception.getMessage());
    }

    @Test
    public void exp_should_throw_exception_when_calculating_invalid_arguments_using_assertj() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(-10, 10))
                .withMessage("invalid number");
    }
}
