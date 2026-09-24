package VERSION5;

import java.util.ArrayList;
import java.util.List;

/** Dynamically sized aggregation: employee references remain owned by the caller. */
public class EmployeeRoster {
    private final List<Employee> empList;

    public EmployeeRoster() { empList = new ArrayList<>(); }

    public EmployeeRoster(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative.");
        }
        empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        return empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int index = 0; index < empList.size(); index++) {
            if (empList.get(index).getEmpID() == empID) {
                return empList.remove(index);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) return emp;
        }
        return null;
    }

    public int countEmployees() { return empList.size(); }

    public int countHE() {
        int count = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) count++;
        }
        return count;
    }

    public int countPWE() {
        int count = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) count++;
        }
        return count;
    }

    /** Includes base-plus employees, which are also commission employees. */
    public int countCE() {
        int count = 0;
        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee) count++;
        }
        return count;
    }

    public int countBPCE() {
        int count = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) count++;
        }
        return count;
    }

    public void displayHE() {
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) System.out.println(emp);
        }
    }

    public void displayPWE() {
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) System.out.println(emp);
        }
    }

    public void displayAllEmployees() {
        for (Employee emp : empList) System.out.println(emp);
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            System.out.printf(java.util.Locale.ENGLISH,
                    "ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary,
                    salary > emp.computeSalary() ? " (Birthday Bonus Applied)" : "");
        }
    }

    public double computeSalary(int index, int currentMonth) {
        return empList.get(index).computeSalary(currentMonth);
    }
}

