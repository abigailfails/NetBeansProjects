package testing;

import horoscope.input.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ValidatorTest {

    @Test
    public void inputBoundedInteger() {
        Assert.assertEquals("When the input is within the bounds, it should return the input", 4, Validator.inputBoundedInteger(new Scanner()));
    }

    @Test
    public void inputNonEmptyString() {
    }

    @Test
    public void inputLocalDate() {
    }
}