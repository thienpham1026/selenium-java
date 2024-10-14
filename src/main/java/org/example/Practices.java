package org.example;

public class Practices {
    public static void main(String[] args) {
        String str = "Hello @World";
        System.out.println(ChangeSpecialCharacter(str));

        // Calling the method to extract last 4 characters
        String anotherStr = "swiss";
        PrintLast4Chars(anotherStr);

    }

    private static String ChangeSpecialCharacter(String input) {
        return input.replace('@', '_');
    }

    private static void PrintLast4Chars(String str){
        int size = str.length();
        int counter = size-4;
        for(int i = counter; i<size; i++)
        {
            System.out.print(str.charAt(i));
        }
    }
}
