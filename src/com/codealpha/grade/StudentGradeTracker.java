package com.codealpha.grade;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StudentGradeTracker {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            String choice = JOptionPane.showInputDialog(null,
                    "===== Student Grade Tracker =====\n"
                            + "1. Add Student\n"
                            + "2. View Report\n"
                            + "3. Exit\n"
                            + "Choose an option:");

            if (choice == null) {
                break;
            }

            switch (choice.trim()) {

            case "1":

                String name = JOptionPane.showInputDialog(null, "Student Name:");

                if (name == null || name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty.");
                    break;
                }

                String marksInput = JOptionPane.showInputDialog(null, "Marks:");

                try {
                    double marks = Double.parseDouble(marksInput);
                    students.add(new Student(name, marks));
                    JOptionPane.showMessageDialog(null, "Student Added Successfully!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Marks must be a number.");
                }

                break;

            case "2":

                if (students.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Data Available");
                    break;
                }

                double total = 0;
                Student highest = students.get(0);
                Student lowest = students.get(0);

                StringBuilder report = new StringBuilder("--- Student Report ---\n");

                for (Student s : students) {

                    report.append(s.getName()).append(" : ").append(s.getMarks()).append("\n");

                    total += s.getMarks();

                    if (s.getMarks() > highest.getMarks())
                        highest = s;

                    if (s.getMarks() < lowest.getMarks())
                        lowest = s;
                }

                double average = total / students.size();

                report.append("\nAverage Marks: ").append(average).append("\n");
                report.append("Highest: ").append(highest.getName()).append(" (").append(highest.getMarks()).append(")\n");
                report.append("Lowest: ").append(lowest.getName()).append(" (").append(lowest.getMarks()).append(")");

                JOptionPane.showMessageDialog(null, report.toString());

                break;

            case "3":

                JOptionPane.showMessageDialog(null, "Program Closed");
                System.exit(0);

            default:

                JOptionPane.showMessageDialog(null, "Invalid Choice");
            }
        }
    }
}