package org.example;

import java.util.*;

public class CaroGame {
    static char[][] board = new char[3][3];
    static char playerMark = 'X';
    static char machineMark = 'O';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        int turns = 0;
        while (turns < 6) {
            playerMove();
            printBoard();
            if (checkWin(playerMark)) {
                System.out.println("Player wins!");
                return;
            }
            turns++;

            if (turns == 6) break;

            machineMove();
            printBoard();
            if (checkWin(machineMark)) {
                System.out.println("Machine wins!");
                return;
            }
            turns++;
        }

        System.out.println("It's a draw!");
    }

    public static void initializeBoard() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (count + '0');
                count++;
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            if (i > 0) {
                System.out.println("-------------");
            }
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int move = -1; // Khởi tạo với giá trị không hợp lệ

        while (true) {
            System.out.println("Enter your move (1-9): ");

            // Kiểm tra xem đầu vào có phải là số nguyên không
            if (scanner.hasNextInt()) {
                move = scanner.nextInt(); // Đọc giá trị số nguyên

                // Kiểm tra xem số có nằm trong khoảng từ 1 đến 9 không
                if (move < 1 || move > 9) {
                    System.out.println("Invalid move! Please enter a number between 1 and 9.");
                } else if (isValidMove(move)) {
                    placeMark(move, playerMark);
                    break; // Kết thúc vòng lặp nếu nước đi hợp lệ
                } else {
                    System.out.println("That position is already taken. Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Bỏ qua đầu vào không phải số
            }
        }
    }

    public static boolean isValidMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] != playerMark && board[row][col] != machineMark;
    }

    public static void placeMark(int move, char mark) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = mark;
    }

    public static void machineMove() {
        Random rand = new Random();
        int move;
        while (true) {
            move = rand.nextInt(9) + 1;
            if (isValidMove(move)) {
                placeMark(move, machineMark);
                System.out.println("Machine's move: " + move);
                break;
            }
        }
    }

    public static boolean checkWin(char mark) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                    (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
        if ((board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)) {
            return true;
        }
        return false;
    }
}
