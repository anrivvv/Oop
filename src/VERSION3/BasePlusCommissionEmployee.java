package VERSION3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() { super(); }
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative.");
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee();
        System.out.printf("Base Salary: ₱%,.2f%n", baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%,.2f, Base Salary: ₱%,.2f, Commission: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), getTotalSale(), baseSalary,
                getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), baseSalary); }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
