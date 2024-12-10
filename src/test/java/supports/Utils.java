package supports;

import java.util.Random;

public class Utils {

    // dynamic test data generator
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static String calculateBmi(double weight, double height) {
        double convertHeight = height / 100; // Convert height to meters
        double bmi = weight / (convertHeight * convertHeight); // Calculate BMI

        // Round BMI to 1 decimal place and return the formatted string
        return String.format("BMI = %.1f kg/m2", bmi);
    }
}
