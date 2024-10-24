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

    public static String returnFirstAlphabet(String string) {
        StringBuilder result = new StringBuilder();
        String[] split = string.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) { // Ensure we skip any empty strings
                result.append(split[i].charAt(0));
            }
        }

        return result.toString();
    }

    public static String removeSpecialCharacters(String str){
        String newStr = str.replaceAll("[%^#$()!_+@]", "");
        return newStr;
    }

    public static String getSentenceWithoutDuplicates(String str) {
        String[] strSplit = str.split("\\s");
        Map<String, Integer> map = new HashMap<>();
        int counter = 1;

        for (int i = 0; i < strSplit.length; i++) {
            if (map.containsKey(strSplit[i])) {
                map.put(strSplit[i], map.get(strSplit[i]) + 1);
            } else {
                map.put(strSplit[i], counter);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String word : strSplit) {
            if (map.get(word) == 1) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static String removeWhiteSpace(String str){
        String newStr = str.replaceAll("\\s", "");
        return newStr;
    }

    public static String getReverseOfString(String str) {
        StringBuilder reversedStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr.append(str.charAt(i));
        }
        return reversedStr.toString();
    }
}
