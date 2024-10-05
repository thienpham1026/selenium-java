package org.example;

import java.util.*;

public class Caro {
    public static String[][] board = new String[3][3];
    public static String machine = "O";
    public static String human = "X";
    public static int[] humanSelect = new int[3];
    public static int[] computerSelect = new int[3];

    public static List<Integer> availableCells = new ArrayList<>();

    public static void main(String[] args) {
        availableCells.add(1);
        availableCells.add(2);
        availableCells.add(3);
        availableCells.add(4);
        availableCells.add(5);
        availableCells.add(6);
        availableCells.add(7);
        availableCells.add(8);
        availableCells.add(9);
        Scanner input = new Scanner(System.in);
        System.out.println("select 1-9");

        for (int i = 0; i < 3; i++) {
            int humanInput = input.nextInt();
            System.out.println("You selected " + humanInput);
            if (!availableCells.contains(humanInput)) {
                System.out.println("please select other cell");
                humanInput = input.nextInt();
            }
            humanSelect[i] = humanInput;
            availableCells.remove(availableCells.indexOf(humanInput));

            selectCell(humanInput, human);
            int computerInput = availableCells.get(generateRandom(0, availableCells.size() - 1));
            System.out.println("Computer selected " + computerInput);

            computerSelect[i] = computerInput;
            availableCells.remove(availableCells.indexOf(computerInput));

            selectCell(computerInput, machine);
            printTable();
        }

        checkWinner();

    }

    public static void checkWinner() {
        List<int[]> win = new ArrayList<>();
        win.add(new int[]{1, 2, 3});
        win.add(new int[]{4, 5, 6});
        win.add(new int[]{7, 8, 9});
        win.add(new int[]{1, 4, 7});
        win.add(new int[]{2, 5, 8});
        win.add(new int[]{3, 6, 9});
        win.add(new int[]{1, 5, 9});
        win.add(new int[]{3, 5, 7});
        Arrays.sort(computerSelect);
        Arrays.sort(humanSelect);
        int result = 0;
        for (int[] ints : win) {
            if (Arrays.equals(humanSelect, ints)) {
                result = 1;
                break;
            } else if (Arrays.equals(computerSelect, ints)) {
                result = 2;
                break;
            }
        }
        if (result == 0) {
            System.out.println("Draw");
        } else if (result == 1) {
            System.out.println("You Won");
        } else {
            System.out.println("You Loose");
        }
    }

    public static void selectCell(int cell, String player) {
        switch (cell) {
            case 1: {
                board[0][0] = player;
                break;
            }
            case 2: {
                board[0][1] = player;
                break;
            }
            case 3: {
                board[0][2] = player;
                break;
            }
            case 4: {
                board[1][0] = player;
                break;
            }
            case 5: {
                board[1][1] = player;
                break;
            }
            case 6: {
                board[1][2] = player;
                break;
            }
            case 7: {
                board[2][0] = player;
                break;
            }
            case 8: {
                board[2][1] = player;
                break;
            }
            case 9: {
                board[2][2] = player;
                break;
            }
        }
    }

    public static void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + (board[row][col] != null ? board[row][col] : " ") + " ");
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------------");
            }
        }
    }

    public static int generateRandom(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException("Invalid range: a must be less than or equal to b");
        }
        Random rand = new Random();
        return rand.nextInt(b - a + 1) + a;
    }
}

