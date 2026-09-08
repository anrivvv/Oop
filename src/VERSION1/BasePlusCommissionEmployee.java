package VERSION1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    //Partial Constructor
    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    //Full Constructor
    public BasePlusCommissionEmployee(int empID, String empName,
                                      double totalSale,
                                      double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }
    public String getEmpName() {
        return empName;
    }
    public double getTotalSale() {
        return totalSale;
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    // Setters
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
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
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
        double commission =
                totalSale * getCommissionRate();

        return baseSalary + commission;
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                empID, empName, totalSale, baseSalary
        );
    }


    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d | Name: %s | Sales: ₱%.2f | Base Salary: ₱%.2f | Commission: %.0f%% | Total Salary: ₱%.2f]",
                empID, empName, totalSale, baseSalary,
                getCommissionRate() * 100,
                computeSalary()
        );
    }
}
