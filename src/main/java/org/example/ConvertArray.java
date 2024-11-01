package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConvertArray {
    public static void main(String[] args) {
        int[] A = {3, 8, 0, 9};

        findNumber(A);

        addOneToArray(A);

        int[] arr = {10, 90, 9, 40, 5, 25};
        printMaximumDifference(arr);

        int[] printArr = {4, 2, 3, 5, 1, 2, 4};
        printRepeatingElements(printArr);

        int[] negArr = {-1, 2, 3, -4, -7, 8};
        moveNegativeNumbersTOStart(negArr);

        String str = "abcd";
        printSubstrings(str);

        String strPrint = "Learn with Japneet Sachdeva";
        printAllCharacters(strPrint);
    }

    // Function to add 1 to the array of digits
    public static int[] addOneToArray(int[] array) {
        int n = array.length;
        int carry = 1;  // Start with carry as 1 because we need to add 1 to the number

        for (int i = n - 1; i >= 0; i--) {
            int sum = array[i] + carry;
            array[i] = sum % 10;  // Update the current digit
            carry = sum / 10;     // Calculate new carry
        }

        // If there is still a carry left, we need to resize the array to accommodate the new digit
        if (carry > 0) {
            int[] newArray = new int[n + 1];
            newArray[0] = carry;  // The carry will be the new leading digit
            System.arraycopy(array, 0, newArray, 1, n);
            System.out.println("Result: " + Arrays.toString(newArray));
            return newArray;
        }

        System.out.println("Result: " + Arrays.toString(array));
        return array;
    }

    // Function to add 1 to the array of digits
    public static void findNumber(int[] array) {
        int max = array[0];
        int min = array[0];
        int max_second = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max_second = max;
                max = array[i];
            } else if (array[i] > max_second && array[i] != max) {
                max_second = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Second Max: " + max_second);
        System.out.println("Min: " + min);
    }

    public static void printMaximumDifference(int[] arr) {
        //Approach find greatest and smallest number in java and then subtract it.
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.print("Max Difference is: " + (max - min));
    }

    public static void printRepeatingElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer mapValue = map.get(arr[i]);

            if (mapValue == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], mapValue + 1);
            }
        }

        System.out.println("\n" + map);
        //Now we need to retrieve only keys which are greater than value = 1
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() > 1) {
                System.out.println("Key: " + mapEntry.getKey() + " Repeat: " + mapEntry.getValue());
            }
        }
    }

    public static void moveNegativeNumbersTOStart(int[] arr) {
        int[] tempArr = new int[arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                tempArr[counter] = arr[i];
                counter++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                tempArr[counter] = arr[i];
                counter++;
            }
        }
        System.out.print(Arrays.toString(tempArr));
    }

    public static void printSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println("\n" + str.substring(i, j));
            }
        }
    }

    public static void printAllCharacters(String str) {
        //TODO: WordCount
        String[] strArray = str.split(" ");
        int wordCount = strArray.length;
        System.out.println("Count: " + wordCount);

        //TODO: Print Vowels
        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A' || str.charAt(i) == 'e' || str.charAt(i) == 'E' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'I' || str.charAt(i) == 'o' || str.charAt(i) == 'O' || str.charAt(i) == 'u' || str.charAt(i) == 'U') {
                vowelCount++;
            }
        }

        System.out.println("Vowel count is: " + vowelCount);

        //Todo: Frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (freqMap.containsKey(str.charAt(i))) {
                freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
            } else {
                freqMap.put(str.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.print("\n Character: " + entry.getKey() + "\n Frequency: " + entry.getValue());
        }
    }
}


