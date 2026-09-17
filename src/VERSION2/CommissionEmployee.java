package VERSION2;

public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() { this(0, new Name(), new MyDate(), new MyDate(), 0); }
    public CommissionEmployee(int empID, Name empName) { this(empID, empName, new MyDate(), new MyDate(), 0); }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0);
    }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
    }
    public int getEmpID() { return empID; }
    public Name getEmpName() { return empName; }
    public MyDate getBirthDate() { return birthDate; }
    public MyDate getDateHired() { return dateHired; }
    public double getTotalSale() { return totalSale; }
    public void setEmpID(int empID) { this.empID = empID; }
    public void setEmpName(Name empName) { this.empName = empName; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }
    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) this.totalSale = totalSale;
    }
    private double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }
    public double computeSalary() { return totalSale * getCommissionRate(); }
    public double computeSalary(int currentMonth) {
        return computeSalary() + (birthDate != null && birthDate.getMonth() == currentMonth ? 5000 : 0);
    }
    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: ₱%,.2f%n",
                empID, empName, birthDate, dateHired, totalSale);
    }
    @Override public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%,.2f, Commission: %.0f%%, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalSale, getCommissionRate() * 100, computeSalary());
    }
}
