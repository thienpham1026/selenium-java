package org.example;

public class Test {
    public static void main(String[] args) {
        String str = "Hello @World";
        System.out.println(test(str));
    }

    private static String test(String input) {
        return input.replace('@', '_');
    }
}
