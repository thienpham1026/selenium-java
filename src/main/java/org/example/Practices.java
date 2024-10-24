package org.example;

import java.util.HashMap;
import java.util.Map;

public class Practices {

    public static String changeSpecialCharacter(String input) {
        return input.replace('@', '_');
    }

    public static String printLast4Chars(String str){
        if (str.length() >= 4) {
            return str.substring(str.length() - 4);
        } else {
            return "String is too short";
        }
    }

    public static String findNonRepeatingCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return String.valueOf(str.charAt(i)); // Return first non-repeating character
            }
        }

        return "No non-repeating character found";
    }

}
