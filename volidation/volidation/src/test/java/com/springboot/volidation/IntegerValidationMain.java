package com.springboot.volidation;

import org.apache.commons.validator.routines.IntegerValidator;

import java.util.Locale;

public class IntegerValidationMain {
    public static void main(String[] args) {
        IntegerValidator validator = IntegerValidator.getInstance();
        Integer value = validator.validate("100");
        System.out.println(value);
        value = validator.validate("A");
        System.out.println(value);
        String value2 = validator.format(100000, Locale.ENGLISH);
        System.out.println(value2);
    }
}
