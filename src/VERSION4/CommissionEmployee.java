package VERSION4;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() { super(); }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() { return totalSale; }
    public final void setTotalSale(double totalSale) {
        if (totalSale < 0) throw new IllegalArgumentException("Sales cannot be negative.");
        this.totalSale = totalSale;
    }
    public double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return totalSale * getCommissionRate() + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf("Sales: ₱%,.2f | Commission: %.0f%%%n",
                totalSale, getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [%s, Sales: ₱%,.2f, Commission: %.0f%%, Total Salary: ₱%,.2f]",
                super.toString(), totalSale, getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalSale); }

    @Override
    public CommissionEmployee clone() { return (CommissionEmployee) super.clone(); }
}
