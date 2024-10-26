package org.example;

public class PasswordValidator {

    public static void main(String[] args) {
        // Example
        System.out.println(is_valid_password("Password1!"));  // true
        System.out.println(is_valid_password("password"));    // false
    }

    /**
     * ## Password Complexity
     * * len > 8 characters
     * * include number
     * * include lowercases
     * * include uppercases
     * * include !@#$%^&*()
     * * * **create a function**:
     * * - String as input
     * * - Boolean as output
     */
    public static boolean is_valid_password(String password) {
        return check_password_len(password)
                && check_contain_lower(password)
                && check_contain_upper(password)
                && check_contain_digit(password)
                && check_special_char(password);
    }

    private static boolean check_password_len(String password) {
        return password.length() >= 8;
    }

    private static boolean check_contain_lower(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean check_contain_upper(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean check_contain_digit(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean check_special_char(String password) {
        for (int i = 0; i < password.length(); i++) {
            if ("!@#$%^&*()".contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}