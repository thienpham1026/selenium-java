package org.example;

public class Exercise {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isVowels(String input) {
        if (input.length() != 1) throw new IllegalArgumentException("input string length must be equals 1");
        return "aeiouAEIOU".contains(input);
    }

    public static boolean isPasswordComplex(String input) {
        // Regex to validate the password complexity
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{9,}$";
        return input.matches(regex);
    }
}