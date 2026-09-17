package VERSION3;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() { super(); }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public double getRatePerHour() { return ratePerHour; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) throw new IllegalArgumentException("Hours cannot be negative.");
        this.totalHoursWorked = totalHoursWorked;
    }
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) throw new IllegalArgumentException("Hourly rate cannot be negative.");
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double regular = Math.min(totalHoursWorked, 40) * ratePerHour;
        double overtime = Math.max(totalHoursWorked - 40, 0) * ratePerHour * 1.5;
        return regular + overtime + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.printf("Hours: %.2f | Rate: ₱%,.2f/hr%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [%s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                super.toString(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour); }

    @Override
    public HourlyEmployee clone() { return (HourlyEmployee) super.clone(); }
}
