package VERSION6;

import java.util.Objects;

public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    protected Employee() { this(0, new Name(), new MyDate(), new MyDate()); }
    protected Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = Objects.requireNonNull(empName, "Employee name cannot be null.").clone();
        this.birthDate = Objects.requireNonNull(birthDate, "Birth date cannot be null.").clone();
        this.dateHired = Objects.requireNonNull(dateHired, "Hire date cannot be null.").clone();
    }

    public final int getEmpID() { return empID; }
    public final Name getEmpName() { return empName.clone(); }
    public final MyDate getBirthDate() { return birthDate.clone(); }
    public final MyDate getDateHired() { return dateHired.clone(); }
    public final void setEmpName(Name empName) { this.empName = Objects.requireNonNull(empName, "Employee name cannot be null.").clone(); }
    public final void setBirthDate(MyDate birthDate) { this.birthDate = Objects.requireNonNull(birthDate, "Birth date cannot be null.").clone(); }
    public final void setDateHired(MyDate dateHired) { this.dateHired = Objects.requireNonNull(dateHired, "Hire date cannot be null.").clone(); }

    public final double getBirthdayBonus(int currentMonth) {
        validateMonth(currentMonth);
        return birthDate.getMonth() == currentMonth ? 5000.0 : 0.0;
    }

    // -1 omits the birthday bonus for the no-argument salary overload.
    static void validateMonth(int month) {
        if (month != -1 && (month < 1 || month > 12)) {
            throw new IllegalArgumentException("Month must be 1 through 12, or -1 for no bonus.");
        }
    }

    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

    @Override
    public String toString() {
        return String.format(java.util.Locale.ENGLISH, "ID: %d, Name: %s, DOB: %s, Hired: %s",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return empID == other.empID
                && Objects.equals(empName, other.empName)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dateHired, other.dateHired);
    }

    @Override
    public int hashCode() { return Objects.hash(empID, empName, birthDate, dateHired); }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
