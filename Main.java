/*
 * Name    : <Your Full Name>
 * Section : <Your Section>
 * Date    : <Date Submitted>
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main - a menu-driven Student Management System.
 * Nothing is hardcoded: every record comes from the user's input.
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add College Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Update a Student");
            System.out.println("5. Show Total Students Created");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            if (!sc.hasNextLine()) break; // no more input (e.g. Ctrl+D)

            try {
                switch (sc.nextLine().trim()) {
                    case "1": addStudent(false);   break;
                    case "2": addStudent(true);    break;
                    case "3": displayAll();        break;
                    case "4": updateStudent();     break;
                    case "5":
                        System.out.println("Total Student objects created: "
                                + Student.getTotalStudents());
                        break;
                    case "6": running = false;     break;
                    default:  System.out.println("Invalid option. Enter 1-6.");
                }
            } catch (IllegalArgumentException e) {
                // Thrown by the validated setters/constructors in Student
                System.out.println("REJECTED: " + e.getMessage());
            }
        }

        System.out.println("\nTotal Student objects created: " + Student.getTotalStudents());
        System.out.println("Goodbye!");
    }

    // ---------- 1 & 2: create objects from user input ----------
    private static void addStudent(boolean college) {
        System.out.println(college ? "\n--- Add College Student ---" : "\n--- Add Student ---");

        String name   = ask("Name: ");
        String id     = ask("Student ID (must start with STU, e.g. STU001): ");
        if (findById(id) != null) {
            throw new IllegalArgumentException("Student ID " + id.trim() + " already exists.");
        }
        String course = ask("Course (e.g. BSIT, BSCS): ");
        int year      = readInt(ask("Year level (1-4): "), "Year level");

        if (college) {
            String scholarship = ask("Scholarship status (Full Scholar / Partial Scholar / None): ");
            students.add(new CollegeStudent(name, id, course, year, scholarship));
        } else {
            students.add(new Student(name, id, course, year));
        }
        System.out.println("Record saved.");
    }

    // ---------- 3: display everything with loops ----------
    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students yet. Add one first.");
            return;
        }

        System.out.println("\n===== STUDENT INFORMATION =====");
        for (Student s : students) {
            if (!(s instanceof CollegeStudent)) {
                s.displayInfo();
                System.out.println("--------------------");
            }
        }

        System.out.println("===== COLLEGE STUDENT =====");
        for (Student s : students) {
            if (s instanceof CollegeStudent) {
                s.displayInfo(); // overridden version also prints scholarship
                System.out.println("--------------------");
            }
        }
        System.out.println("Total records: " + students.size());
    }

    // ---------- 4: update with setters, show result with getters ----------
    private static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students yet. Add one first.");
            return;
        }

        Student s = findById(ask("Enter the Student ID to update: "));
        if (s == null) {
            System.out.println("No student found with that ID.");
            return;
        }

        boolean isCollege = s instanceof CollegeStudent;
        System.out.println("\nUpdating " + s.getName() + " (" + s.getStudentId() + ")");
        System.out.println("1. Name");
        System.out.println("2. Course");
        System.out.println("3. Year Level");
        if (isCollege) System.out.println("4. Scholarship Status");

        String choice = ask("What do you want to change? ");
        switch (choice.trim()) {
            case "1": s.setName(ask("New name: "));    break;
            case "2": s.setCourse(ask("New course: ")); break;
            case "3": s.setYearLevel(readInt(ask("New year level (1-4): "), "Year level")); break;
            case "4":
                if (!isCollege) { System.out.println("Invalid choice."); return; }
                ((CollegeStudent) s).setScholarshipStatus(ask("New scholarship status: "));
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n===== UPDATED INFORMATION =====");
        System.out.println("Name: " + s.getName());
        System.out.println("Course: " + s.getCourse());
        System.out.println("Year Level: " + s.getYearLevel());
        if (isCollege) {
            System.out.println("Scholarship: " + ((CollegeStudent) s).getScholarshipStatus());
        }
    }

    // ---------- helpers ----------
    private static Student findById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id.trim())) return s;
        }
        return null;
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return sc.hasNextLine() ? sc.nextLine() : "";
    }

    private static int readInt(String text, String label) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(label + " must be a whole number.");
        }
    }
}