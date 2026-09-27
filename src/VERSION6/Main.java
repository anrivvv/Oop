package VERSION6;

import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        // new Employee(); // Compiler error: Employee is abstract.
        check(Modifier.isAbstract(Employee.class.getModifiers()), "Employee must be abstract");
        System.out.println("Employee is abstract: direct instantiation is prohibited.");

        System.out.println("\nTESTING ENCAPSULATION & DEFENSIVE COPYING");
        MyDate birth = new MyDate(6, 8, 2006);
        HourlyEmployee employee = new HourlyEmployee(101,
                new Name("Osbev Erica", "Delos Reyes", "Cabucos"),
                birth, new MyDate(1, 6, 2022), 45, 200);
        System.out.println("Original birth date: " + employee.getBirthDate());
        birth.setMonth(9);
        employee.getBirthDate().setMonth(9);
        check(employee.getBirthDate().getMonth() == 8, "Birth date must be protected");
        check(employee.getBirthdayBonus(9) == 0, "External changes must not grant a bonus");
        System.out.println("Birth date after external changes: " + employee.getBirthDate());
        System.out.println("SUCCESS: constructor and getter copies protect internal state.");

        System.out.println("\nTESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("The following exceptions are intentional tests and are caught safely.");
        expectInvalid("Negative hourly rate", () -> new HourlyEmployee(102,
                new Name("Test", "Employee"), new MyDate(), new MyDate(), 40, -150));
        expectInvalid("February 30", () -> new MyDate(30, 2, 2026));
        expectInvalid("Blank first name", () -> new Name(" ", "Employee"));
        expectInvalid("Non-finite sales", () -> new CommissionEmployee().setTotalSale(Double.NaN));

        EmployeeRoster roster = new EmployeeRoster(1);
        roster.addEmployee(employee);
        roster.addEmployee(new PieceWorkerEmployee(201,
                new Name("Zev", "Ampoloqio", "Torrentira", "Jr."),
                new MyDate(25, 8, 2001), new MyDate(15, 1, 2023), 250, 15));
        roster.addEmployee(new CommissionEmployee(301,
                new Name("Drixyl Reece Irish", "Nax", "Nacu"),
                new MyDate(22, 9, 2004), new MyDate(10, 3, 2020), 100000));
        roster.addEmployee(new BasePlusCommissionEmployee(401,
                new Name("Virna Zeth", "Malahay", "Arias"),
                new MyDate(9, 1, 2005), new MyDate(5, 8, 2019), 80000, 24000));
        try {
            roster.addEmployee(null);
            throw new AssertionError("Null employee was accepted");
        } catch (NullPointerException expected) {
            System.out.println("Caught expected NullPointerException: " + expected.getMessage());
        }

        System.out.println("\nPOLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        roster.displayPayroll(9);
        System.out.printf("Total: %d | Hourly: %d | Piece worker: %d | Commission (including base-plus): %d | Base-plus: %d%n",
                roster.countEmployees(), roster.countHE(), roster.countPWE(), roster.countCE(), roster.countBPCE());
        System.out.println("Version 6 verification passed.");
    }

    private static void expectInvalid(String label, Runnable action) {
        try {
            action.run();
            throw new AssertionError(label + " was accepted");
        } catch (IllegalArgumentException expected) {
            System.out.println(label + ": caught IllegalArgumentException: " + expected.getMessage());
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
