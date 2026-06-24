package com.codealpha.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Student Name: ");
                String name = sc.nextLine();

                System.out.print("Marks: ");
                double marks = sc.nextDouble();

                students.add(new Student(name, marks));

                System.out.println("Student Added Successfully!");
                break;

            case 2:

                if (students.isEmpty()) {
                    System.out.println("No Data Available");
                    break;
                }

                double total = 0;
                Student highest = students.get(0);
                Student lowest = students.get(0);

                System.out.println("\n--- Student Report ---");

                for (Student s : students) {

                    System.out.println(s.getName() + " : " + s.getMarks());

                    total += s.getMarks();

                    if (s.getMarks() > highest.getMarks())
                        highest = s;

                    if (s.getMarks() < lowest.getMarks())
                        lowest = s;
                }

                double average = total / students.size();

                System.out.println("\nAverage Marks: " + average);
                System.out.println("Highest: " + highest.getName() + " (" + highest.getMarks() + ")");
                System.out.println("Lowest: " + lowest.getName() + " (" + lowest.getMarks() + ")");

                break;

            case 3:

                System.out.println("Program Closed");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice");
            }
        }
    }
}