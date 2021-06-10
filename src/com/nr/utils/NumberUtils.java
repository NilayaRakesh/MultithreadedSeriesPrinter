package com.nr.utils;

public class NumberUtils {

    private NumberUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isOdd(int number) {
        return number%2==1;
    }

    public static boolean isEven(int number) {
        return number%2==0;
    }
}
