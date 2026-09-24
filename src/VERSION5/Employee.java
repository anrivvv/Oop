package VERSION5;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() { this(0, new Name(), new MyDate(), new MyDate()); }
    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = Objects.requireNonNull(empName, "Employee name cannot be null.");
        this.birthDate = Objects.requireNonNull(birthDate, "Birth date cannot be null.");
        this.dateHired = Objects.requireNonNull(dateHired, "Hire date cannot be null.");
    }

    public int getEmpID() { return empID; }
    public Name getEmpName() { return empName; }
    public MyDate getBirthDate() { return birthDate; }
    public MyDate getDateHired() { return dateHired; }
    public void setEmpID(int empID) { this.empID = empID; }
    public void setEmpName(Name empName) { this.empName = Objects.requireNonNull(empName); }
    public void setBirthDate(MyDate birthDate) { this.birthDate = Objects.requireNonNull(birthDate); }
    public void setDateHired(MyDate dateHired) { this.dateHired = Objects.requireNonNull(dateHired); }

    public final double getBirthdayBonus(int currentMonth) {
        return birthDate.getMonth() == currentMonth ? 5000.0 : 0.0;
    }

    public double computeSalary(int currentMonth) {
        return 0.0;
    }
    public double computeSalary() { return computeSalary(-1); }

    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, DOB: %s, Hired: %s",
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
