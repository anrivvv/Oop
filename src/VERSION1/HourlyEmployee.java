package VERSION1;

public class HourlyEmployee {

    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    //Default-like Constructor
    public HourlyEmployee(){
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    //Partial Constructor
    public HourlyEmployee(int empID, String empName){
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    //Full Constructor
    public HourlyEmployee(int empID, String empName, float
            totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    //Getters
    public int getEmpID(){
        return empID;
    }
    public String getEmpName(){
        return empName;
    }
    public float getTotalHoursWorked(){
        return totalHoursWorked;
    }
    public double getRatePerHour(){
        return ratePerHour;
    }

    //Setters
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    //computeSalary
    public double computeSalary(){
        if (totalHoursWorked <= 40){
            return totalHoursWorked * ratePerHour;
        }
        double basePay = 40 * ratePerHour;
        double bonusPay = (totalHoursWorked - 40) * (ratePerHour * 1.5);

        return basePay * bonusPay;
    }

    //displayHourlyEmployee
    public void displayHourlyEmployee(){
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: %.2f/hr%n",
                empID, empName, totalHoursWorked, ratePerHour);
    }

    //toString
    @Override
    public String toString(){
        return String.format("HourlyEmployee [ID: %d | Name: %s | Hours: %.2f | Rate: %.2f | Total Salary:  ₱%.2f]",
                empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
}
