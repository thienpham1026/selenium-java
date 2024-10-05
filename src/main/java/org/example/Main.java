package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Student studentA = new Student("Thien");
//        studentA.info();

        List<Student> students = List.of(
                new Student("Thien"),
                new Student("Lan"),
                new Student("Hanh"),
                new Student("Hue"),
                new Student("Cuc"),
                new Student("Dao"),
                new Student("Hong"),
                new Student("Ly"),
                new Student("Kieu"),
                new Student("Trang")
        );

//        for (Student student : students) {
//            student.info();
//            System.out.println("\n=================");
//        }

        // get max Math
        Student maxMathPoinsStudent = students.stream()
                .max(Comparator.comparing(Student::getMath))
                .get();
        System.out.println("====== Max math point Student ======");
        maxMathPoinsStudent.info();

        // get list of math points
        List<Integer> mathPoints = students.stream().map(Student::getMath).toList();

        for(int p : mathPoints) {
            System.out.println(p);
        }

        // sort by name
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(student -> System.out.println(student.getName()));

        List<Student> subStudents = students
                .stream()
                .filter(student -> student.getPhysic() >= 5).toList();

        subStudents.forEach(Student::info);


//        kiem_tra_nguyen_am("u"); // true
//        kiem_tra_nguyen_am("e"); // true
//        kiem_tra_nguyen_am("o"); // true
//        kiem_tra_nguyen_am("a"); // true
//        kiem_tra_nguyen_am("i"); // true
//        kiem_tra_nguyen_am("U"); // true
//        kiem_tra_nguyen_am("E"); // true
//        kiem_tra_nguyen_am("O"); // true
//        kiem_tra_nguyen_am("A"); // true
//        kiem_tra_nguyen_am("I"); // true
//        kiem_tra_nguyen_am("h"); // false
//
//        String sentence = "Learn with Japneet Sachdeva";
//        int count = 0;
//        for (int i = 0; i < sentence.length(); i++) {
//            char c = sentence.charAt(i);
//            if (kiem_tra_nguyen_am(c + "")) {
//                System.out.println(sentence.charAt(i));
//                count += 1;
//            }
//        }
//        System.out.println("Tim thay " + count + " nguyen am");
//
//        /*
//
//         */
//        String password = "pH$A6fdN";
//
//        if (is_valid_password(password)) {
//            System.out.println("password is valid");
//        } else {
//            System.out.println("password is invalid");
//        }
    }

    public static boolean kiem_tra_nguyen_am(String c) {
        if (c.length() != 1) throw new IllegalArgumentException("input a letter only");
        if (c.matches("[aoeuiAOEUI]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean is_valid_password(String password) {
        return check_password_len(password)
                && check_contain_lower(password)
                && check_contain_upper(password)
                && check_contain_digit(password)
                && check_special_char(password);
    }

    public static boolean check_password_len(String password) {
        return password.length() >= 8;
    }

    public static boolean check_contain_lower(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean check_contain_upper(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean check_contain_digit(String password) {
        for (int i = 0; i < password.length(); i++) {

            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean check_special_char(String password) {
        for (int i = 0; i < password.length(); i++) {
            if ("!@#$%^&*".contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}