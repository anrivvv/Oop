package VERSION6;

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
    public final void setTotalHoursWorked(float totalHoursWorked) {
        if (!Double.isFinite(totalHoursWorked) || totalHoursWorked < 0) throw new IllegalArgumentException("Hours must be finite and non-negative.");
        this.totalHoursWorked = totalHoursWorked;
    }
    public final void setRatePerHour(double ratePerHour) {
        if (!Double.isFinite(ratePerHour) || ratePerHour < 0) throw new IllegalArgumentException("Hourly rate must be finite and non-negative.");
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary() { return computeSalary(-1); }

    @Override
    public void displayEmployee() { System.out.println(this); }

    @Override
    public double computeSalary(int currentMonth) {
        double regular = Math.min(totalHoursWorked, 40) * ratePerHour;
        double overtime = Math.max(totalHoursWorked - 40, 0) * ratePerHour * 1.5;
        return regular + overtime + getBirthdayBonus(currentMonth);
    }

    public void displayHourlyEmployee() { displayEmployee(); }

    @Override
    public String toString() {
        return String.format(java.util.Locale.ENGLISH, "HourlyEmployee [%s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
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
