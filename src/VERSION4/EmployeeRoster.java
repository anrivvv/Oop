package VERSION4;

import VERSION4.Employee;

public class EmployeeRoster {
        private Employee[] empList;
        private int max;
        private int count;

        //Constructor
        public EmployeeRoster() {
            this.max = 10;
            empList = new Employee[max];
            this.count = 0; 
        }
        
        public EmployeeRoster(int max) {
            this.max = max;
            empList = new Employee[max];
            this.count = 0; 
        }

        //Mutator & Manager Methods
        boolean addEmployee(Employee emp){
            if (count < max) {
                empList[count] = emp;
                count++;
                return true;
            }
            return false;
        }

        Employee removeEmployee(int empID){
            for (int i = 0; i < count; i++) {
                if (empList[i].getEmpID() == empID) {
                    Employee removedEmp = empList[i];
                    for (int j = i; j < count - 1; j++) {
                        empList[j] = empList[j + 1];
                    }
                    empList[count - 1] = null;
                    count--;
                    return removedEmp;
                }
            }
            return null;
        }
        
        Employee searchEmployee(int empID){
            for (int i = 0; i < count; i++) {
                if (empList[i].getEmpID() == empID) {
                    return empList[i];
                }
            }
            return null;
        }

        //Polymorphic & Introspection Methods
        int countHE(){
            int heCount = 0;
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof HourlyEmployee) {
                    heCount++;
                }
            }
            return heCount;
        }
         
        int countPWE(){
            int pweCount = 0;
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof PieceWorkerEmployee) {
                    pweCount++;
                }
            }
            return pweCount;
        }

        int countCE(){
            int ceCount = 0;
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof CommissionEmployee) {
                    ceCount++;
                }
            }
            return ceCount;
        }

        int countBPCE(){
            int bpceCount = 0;
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof BasePlusCommissionEmployee) {
                    bpceCount++;
                }
            }
            return bpceCount;
        }

        void displayHE(){
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof HourlyEmployee) {
                    ((HourlyEmployee) empList[i]).displayHourlyEmployee();
                }
            }
        }

        void displayPWE(){
            for (int i = 0; i < count; i++) {
                if (empList[i] instanceof PieceWorkerEmployee) {
                    ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
                }
            }
        }
        
        void displayAllEmployees(){
            for (int i = 0; i < count; i++) {
                System.out.println(empList[i]);
            }
        }

        void displayPayroll(int currentMonth){
            for (int i = 0; i < count; i++) {
                System.out.printf("ID: %d | Name: %s | Salary: ₱%,.2f%n",
                        empList[i].getEmpID(), empList[i].getEmpName(), empList[i].computeSalary(currentMonth));
            }
        }

        //4. Implementation Guidelines for Polymorphism & Downcasting
        
        double computeSalary(int index, int currentMonth) {
            Employee emp = empList[index];

            if (emp instanceof BasePlusCommissionEmployee) {
                return ((BasePlusCommissionEmployee) emp).computeSalary(currentMonth);
            }

            if (emp instanceof CommissionEmployee) {
                return ((CommissionEmployee) emp).computeSalary(currentMonth);
            }

            if (emp instanceof PieceWorkerEmployee) {
                return ((PieceWorkerEmployee) emp).computeSalary(currentMonth);
            }

            if (emp instanceof HourlyEmployee) {
                return ((HourlyEmployee) emp).computeSalary(currentMonth);
            }

            return 0.0;
        }

        
    }
