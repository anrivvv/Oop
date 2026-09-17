package VERSION2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() { this(0, new Name(), new MyDate(), new MyDate(), 0, 0); }
    public HourlyEmployee(int empID, Name empName) { this(empID, empName, new MyDate(), new MyDate(), 0, 0); }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0, 0);
    }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() { return empID; }
    public Name getEmpName() { return empName; }
    public MyDate getBirthDate() { return birthDate; }
    public MyDate getDateHired() { return dateHired; }
    public float getTotalHoursWorked() { return totalHoursWorked; }
    public double getRatePerHour() { return ratePerHour; }
    public void setEmpID(int empID) { this.empID = empID; }
    public void setEmpName(Name empName) { this.empName = empName; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }
    public void setTotalHoursWorked(float totalHoursWorked) { this.totalHoursWorked = totalHoursWorked; }
    public void setRatePerHour(double ratePerHour) { this.ratePerHour = ratePerHour; }

    public double computeSalary() {
        return Math.min(totalHoursWorked, 40) * ratePerHour
                + Math.max(totalHoursWorked - 40, 0) * ratePerHour * 1.5;
    }
    public double computeSalary(int currentMonth) {
        return computeSalary() + (birthDate != null && birthDate.getMonth() == currentMonth ? 5000 : 0);
    }
    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour);
    }
    @Override public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour, computeSalary());
    }
}
