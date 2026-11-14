/*
 * Name    : <Your Full Name>
 * Section : <Your Section>
 * Date    : <Date Submitted>
 */

/**
 * Student - the parent class. Holds the basic record of any student.
 * Attributes are PRIVATE (encapsulation); access is through public
 * getters and validated setters.
 */
public class Student {

    // ---------- Private attributes ----------
    private String name;
    private String studentId;
    private String course;
    private int yearLevel;

    // Bonus: static counter shared by ALL Student objects (and subclasses)
    private static int studentCount = 0;

    // ---------- Constructor ----------
    public Student(String name, String studentId, String course, int yearLevel) {
        // Use the validated setters so invalid data can never create an object
        setName(name);
        setStudentId(studentId);
        setCourse(course);
        setYearLevel(yearLevel);
        studentCount++; // only reached if every value was valid
    }

    // ---------- Getters ----------
    public String getName()      { return name; }
    public String getStudentId() { return studentId; }
    public String getCourse()    { return course; }
    public int getYearLevel()    { return yearLevel; }

    // ---------- Setters (with validation) ----------
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setStudentId(String studentId) {
        if (studentId == null || !studentId.trim().startsWith("STU")) {
            throw new IllegalArgumentException("Student ID must start with \"STU\".");
        }
        this.studentId = studentId.trim();
    }

    public void setCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            throw new IllegalArgumentException("Course cannot be empty.");
        }
        this.course = course.trim();
    }

    public void setYearLevel(int yearLevel) {
        if (yearLevel < 1 || yearLevel > 4) {
            throw new IllegalArgumentException("Year level must be from 1 to 4 (got " + yearLevel + ").");
        }
        this.yearLevel = yearLevel;
    }

    // ---------- Static accessor for the bonus counter ----------
    public static int getTotalStudents() {
        return studentCount;
    }

    // ---------- Behavior ----------
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + yearLevel);
    }
}