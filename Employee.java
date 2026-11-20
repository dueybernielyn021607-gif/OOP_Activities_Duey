public class Employee {

    // Encapsulation: all attributes are private
    private String name;
    private String employeeId;
    private String department;
    private double monthlySalary;

    // Constructor: sets all four attributes
    public Employee(String name, String employeeId, String department, double monthlySalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        setMonthlySalary(monthlySalary);   // reuse the validated setter
    }

    // Getters
    public String getName()          { return name; }
    public String getEmployeeId()    { return employeeId; }
    public String getDepartment()    { return department; }
    public double getMonthlySalary() { return monthlySalary; }

    // Setters
    public void setName(String name)                 { this.name = name; }
    public void setEmployeeId(String employeeId)     { this.employeeId = employeeId; }
    public void setDepartment(String department)     { this.department = department; }

    // Validated setter: rejects zero or negative salary
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Invalid salary rejected: " + monthlySalary
                    + " (must be greater than 0)");
        }
    }

    // Bonus: annual salary
    public double getAnnualSalary() {
        return monthlySalary * 12;
    }

    // Prints the four required details
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}