package org.example;

import java.util.Arrays;

public class Convert {
    public static void main(String[] args) {
        int[] A = {3, 8, 0, 9};

        // find number
        findNumber(A);

        // cong 1 vao mang
        addOneToArray(A);
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
}


