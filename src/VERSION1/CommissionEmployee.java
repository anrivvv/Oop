package VERSION1;

public class CommissionEmployee {

    //Private attributes
    private int empID;
    private String empName;
    private double totalSale;

    //Default-like Constructor
    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    //Partial Constructor
    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    //Full Constructor
    public CommissionEmployee(int empID, String empName,
                              double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
    }

    //Getters
    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    //Setters
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }


    private double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    //Compute salary
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    //displayCommissionEmployee
    public void displayCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: ₱%.2f%n",
                empID, empName, totalSale
        );
    }

    //toString
    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d | Name: %s | Sales: ₱%.2f | Commission: %.0f%% | Total Salary: ₱%.2f]",
                empID, empName, totalSale,
                getCommissionRate() * 100,
                computeSalary()
        );
    }
}