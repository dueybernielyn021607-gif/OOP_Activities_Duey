public class Manager extends Employee {

    private int teamSize;   // only NEW attribute; the other four are inherited

    public Manager(String name, String employeeId, String department,
                   double monthlySalary, int teamSize) {
        super(name, employeeId, department, monthlySalary);  // must be first statement
        setTeamSize(teamSize);
    }

    public int getTeamSize() {
        return teamSize;
    }

    // Validated setter: teamSize must not be negative
    public void setTeamSize(int teamSize) {
        if (teamSize >= 0) {
            this.teamSize = teamSize;
        } else {
            System.out.println("Invalid team size rejected: " + teamSize
                    + " (must not be negative)");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();                          // reuse parent's printing
        System.out.println("Team Size: " + teamSize); // add the extra detail
    }
}