package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student studentA = new Student("Thien");
        studentA.info();

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

        for (Student student : students) {
            student.info();
            System.out.println("\n=================");
        }

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
    }
}