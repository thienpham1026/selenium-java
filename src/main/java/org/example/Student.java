package org.example;
import java.util.Random;

public class Student {

    // Private fields
    private String name;
    private String id;
    private int math;
    private int physic;
    private int chemistry;

    // Constructor
    public Student(String name) {
        this.name = name;
        Random random = new Random();
        this.id = "TVN-" + random.nextInt(1000);
        this.math = random.nextInt(10); // Random score between 0 and 9
        this.physic = random.nextInt(10);
        this.chemistry = random.nextInt(10);
    }

    // Method to print student information
    public void info() {
        System.out.println("Student name is " + this.name);
        System.out.println("Student Id is " + this.id);
        System.out.println("Math Score: " + this.math);
        System.out.println("Physics Score: " + this.physic);
        System.out.println("Chemistry Score: " + this.chemistry);
    }

    public int totalPoint() {
        return this.math + this.physic + this.chemistry;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public int getPhysic() {
        return physic;
    }

    public int getChemistry() {
        return chemistry;
    }
}