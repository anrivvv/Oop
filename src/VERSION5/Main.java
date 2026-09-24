package VERSION5;

public class Main {
    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster(1);
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        enroll(roster, new HourlyEmployee(101, new Name("Osbev Erica", "Delos Reyes", "Cabucos"),
                new MyDate(6, 8, 2006), new MyDate(1, 6, 2022), 45, 200));
        enroll(roster, new PieceWorkerEmployee(201, new Name("Zev", "Ampoloqio", "Torrentira", "Jr."),
                new MyDate(25, 8, 2001), new MyDate(15, 1, 2023), 250, 15));
        enroll(roster, new CommissionEmployee(301, new Name("Drixyl Reece Irish", "Nax", "Nacu"),
                new MyDate(22, 9, 2004), new MyDate(10, 3, 2020), 100000));
        enroll(roster, new BasePlusCommissionEmployee(401, new Name("Virna Zeth", "Malahay", "Arias"),
                new MyDate(9, 1, 2005), new MyDate(5, 8, 2019), 80000, 24000));
        check(roster.countEmployees() == 4, "Roster grows beyond its initial capacity");
        check(!roster.addEmployee(null), "Null employee is rejected");
        check(new Employee().computeSalary(9) == 0.0, "Base employee has zero salary");
        System.out.println("Total Roster Size: " + roster.countEmployees());
        System.out.printf("Hourly: %d | Piece worker: %d | Commission (including base-plus): %d | Base-plus: %d%n",
                roster.countHE(), roster.countPWE(), roster.countCE(), roster.countBPCE());

        System.out.println("\nPURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        roster.displayPayroll(9);
        check(roster.searchEmployee(101).computeSalary(9) == 9500, "Hourly payroll");
        check(roster.searchEmployee(201).computeSalary(9) == 4050, "Piece-worker payroll");
        check(roster.searchEmployee(301).computeSalary(9) == 20000, "Commission payroll");
        check(roster.searchEmployee(401).computeSalary(9) == 32000, "Base-plus payroll");

        System.out.println("\nCOLLECTION REMOVAL TEST: removing ID 201");
        Employee removed = roster.removeEmployee(201);
        check(removed != null && removed.getEmpID() == 201, "Correct employee removed");
        check(roster.countEmployees() == 3 && roster.searchEmployee(201) == null, "Size and search updated");
        check(roster.searchEmployee(101) != null && roster.searchEmployee(301) != null
                && roster.searchEmployee(401) != null, "Remaining employees preserved");
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        roster.displayAllEmployees();
        System.out.println("Version 5 verification passed.");
    }

    private static void enroll(EmployeeRoster roster, Employee emp) {
        roster.addEmployee(emp);
        System.out.println("Enrolled: " + emp.getEmpName() + " (" + emp.getClass().getSimpleName() + ")");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
