/*
 * Name    : <Your Full Name>
 * Section : <Your Section>
 * Date    : <Date Submitted>
 */

/**
 * CollegeStudent - child class of Student.
 * Inherits name, studentId, course, yearLevel and adds scholarshipStatus.
 */
public class CollegeStudent extends Student {

    // Only NEW attribute; the other four are inherited (not re-declared)
    private String scholarshipStatus;

    public CollegeStudent(String name, String studentId, String course,
                          int yearLevel, String scholarshipStatus) {
        super(name, studentId, course, yearLevel); // must be the first statement
        setScholarshipStatus(scholarshipStatus);
    }

    public String getScholarshipStatus() {
        return scholarshipStatus;
    }

    public void setScholarshipStatus(String scholarshipStatus) {
        if (scholarshipStatus == null || scholarshipStatus.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Scholarship status cannot be empty (e.g. Full Scholar, Partial Scholar, None).");
        }
        this.scholarshipStatus = scholarshipStatus.trim();
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // reuse the parent's printing
        System.out.println("Scholarship: " + scholarshipStatus);
    }
}