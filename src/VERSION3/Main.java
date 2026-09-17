package VERSION3;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        int targetMonth = 9;

        HourlyEmployee hourly = new HourlyEmployee(
                101, new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);
        PieceWorkerEmployee pieceWorker = new PieceWorkerEmployee(
                201, new Name("Bob", "Charles", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15);
        CommissionEmployee commission = new CommissionEmployee(
                301, new Name("Carla", "Anne", "Reyes"),
                new MyDate(12, 9, 1995), new MyDate(10, 3, 2020), 120000);
        BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(
                401, new Name("David", "Luis", "Santos"),
                new MyDate(20, 11, 1992), new MyDate(5, 8, 2019), 550000, 20000);

        Employee[] employees = { hourly, pieceWorker, commission, basePlus };
        printPayrollReport(employees, targetMonth);
        testObjectContracts(hourly);
        testDeepClone(hourly);
    }

    private static void printPayrollReport(Employee[] employees, int targetMonth) {
        String month = Month.of(targetMonth).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        System.out.printf("POLYMORPHIC PAYROLL REPORT (Target Month: %s)%n%n", month);

        for (int index = 0; index < employees.length; index++) {
            Employee employee = employees[index];
            double basePay = employee.computeSalary();
            double totalPayout = employee.computeSalary(targetMonth);
            double birthdayBonus = totalPayout - basePay;
            String eligibility = birthdayBonus > 0 ? "Eligible" : "Ineligible";

            System.out.printf("%d. %s%n", index + 1, employee);
            System.out.printf("   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    basePay, birthdayBonus, eligibility);
            System.out.printf("   Total Payout: ₱%,.2f%n%n", totalPayout);
        }
    }

    private static void testObjectContracts(HourlyEmployee employee) {
        HourlyEmployee identical = new HourlyEmployee(
                employee.getEmpID(), employee.getEmpName().clone(),
                employee.getBirthDate().clone(), employee.getDateHired().clone(),
                employee.getTotalHoursWorked(), employee.getRatePerHour());
        HourlyEmployee modified = identical.clone();
        modified.setRatePerHour(250);

        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("emp1 equals emp1Identical: " + employee.equals(identical));
        System.out.printf("emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n",
                employee.hashCode(), identical.hashCode(),
                employee.hashCode() == identical.hashCode());
        System.out.println("emp1 equals modified employee: " + employee.equals(modified));
    }

    private static void testDeepClone(HourlyEmployee original) {
        HourlyEmployee clone = original.clone();
        String originalName = original.getEmpName().toString();
        clone.getEmpName().setLastName("Taylor");
        clone.getBirthDate().setMonth(10);

        System.out.println("\nDEEP CLONE VERIFICATION");
        System.out.println("Original Name before modification: " + originalName);
        System.out.println("Clone Name changed to:             " + clone.getEmpName());
        System.out.println("Clone birth month changed to:      " + clone.getBirthDate());
        System.out.println("Original Name after modification:  " + original.getEmpName());
        System.out.println("Original birth date unchanged:     " + original.getBirthDate());
        System.out.println("Deep copy successful: "
                + (!original.getEmpName().equals(clone.getEmpName())
                && !original.getBirthDate().equals(clone.getBirthDate())));
    }
}
