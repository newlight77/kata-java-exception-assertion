# kata-java-exception-assertion

When it comes to unit test some service classes, we often encounter situation where one of those classes' method would throw an exception. Now how do we unit test that?

There are many ways :

1. Using classic try-catch
2. Using JUnit Expected = Exception.class
3. Using JUnit @Rule
4. Using JUnit5's assertThrows
5. Using AssertJ's assertThatExceptionOfType

Which one is the cleanest way ?

## Using classic try-catch

```java
@Test
public void exp_should_throw_exception_when_calculating_invalid_arguments_using_try_catch_exception(){
    try {
        calculator.calculate(-10, 10);
    }catch(IllegalArgumentException ex){
        assert(ex.getMessage().contains("invalid number"));
    }
}
```

## Using JUnit Expected = Exception.class

```java
@Test(expected = IllegalArgumentException.class)
public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit_expected_exception() {
    calculator.calculate(-10, 10);
}
```

## Using JUnit @Rule

```java
@Test
public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit_rule(){
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("invalid number");

    calculator.calculate(-10, 10);
}
```

## Using JUnit5's assertThrows

JUnit 5 Jupiter assertions API introduces the assertThrows method for asserting exceptions.

```java
@Test
public void exp_should_throw_exception_when_calculating_invalid_arguments_using_junit5(){
    IllegalArgumentException exception = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> calculator.calculate(-10, 10)
    );
    Assertions.assertEquals("invalid number", exception.getMessage());
}
```

## Using AssertJ's assertThatExceptionOfType

Using Java 8, we can do assertions on exceptions easily, by leveraging AssertJ and lambda expressions.

```java
@Test
public void exp_should_throw_exception_when_calculating_invalid_arguments_using_assertj() {
    org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> calculator.calculate(-10, 10))
            .withMessage("Invalid number");
}
```

AssertJ provides various ways to assert the output of the test :

```java
ex.hasMessage("Index: %s, Size: %s", 2, 2)
ex.hasMessageStartingWith("Index: 2")
ex.hasMessageContaining("2")
ex.hasMessageEndingWith("Size: 2")
ex.hasMessageMatching("Index: \\d+, Size: \\d+")
ex.hasCauseInstanceOf(IOException.class)
ex.hasStackTraceContaining("java.io.IOException");
```

And similarly:

```java
Assertions.assertThatIllegalArgumentException()
Assertions.assertThatIllegalStateException()
Assertions.assertThatIOException()
Assertions.assertThatNullPointerException()
```
