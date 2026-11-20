public class Main {
    public static void main(String[] args) {

        // Part C: create objects
        Employee emp1 = new Employee("Juan Dela Cruz", "EMP001", "IT", 25000.0);
        Employee emp2 = new Employee("Maria Lopez", "EMP002", "HR", 22000.0);
        Manager  emp3 = new Manager("Carlo Mendoza", "EMP003", "IT", 45000.0, 8);

        // Display all
        System.out.println("===== EMPLOYEE INFORMATION =====");
        emp1.displayInfo();
        emp2.displayInfo();

        System.out.println("===== MANAGER =====");
        emp3.displayInfo();

        // Part D: update with a setter, show with getters
        emp2.setMonthlySalary(24000.0);
        System.out.println("===== UPDATED INFORMATION =====");
        System.out.println("Name: " + emp2.getName());
        System.out.println("Monthly Salary: " + emp2.getMonthlySalary());

        // Bonus 1 and 2: array + loop + annual salary
        Employee[] employees = { emp1, emp2, emp3 };
        System.out.println("===== ANNUAL SALARIES (BONUS) =====");
        for (Employee e : employees) {
            System.out.println(e.getName() + " - Annual Salary: " + e.getAnnualSalary());
        }

        // Bonus 3: invalid updates are rejected
        System.out.println("===== VALIDATION TEST (BONUS) =====");
        emp3.setTeamSize(-5);
        emp1.setMonthlySalary(-100);
        System.out.println("Carlo's team size is still: " + emp3.getTeamSize());
        System.out.println("Juan's salary is still: " + emp1.getMonthlySalary());
    }
    /*
 * Answers to Questions
 *
 * 1. Why should monthlySalary be private, and what does the setter protect against?
 *    It is private for encapsulation, so no other class can change it directly.
 *    The setter protects against invalid data: setMonthlySalary() rejects zero
 *    or negative values, so the salary can never be set to a wrong amount.
 *
 * 2. Is a Manager also an Employee? Explain using the word extends.
 *    Yes. Manager extends Employee, which means Manager inherits all of
 *    Employee's attributes and methods. This is an "is-a" relationship, so a
 *    Manager object can be used anywhere an Employee is expected.
 *
 * 3. What is the advantage of calling super.displayInfo() inside Manager's
 *    displayInfo()?
 *    It reuses the parent's code instead of copying it. The name, ID,
 *    department, and salary are printed by Employee, and Manager only adds
 *    the team size. If Employee's display changes, Manager updates too.
 */
}