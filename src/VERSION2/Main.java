package VERSION2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Virna", "Zeth", "Arias");
        MyDate sampleDate = new MyDate(18, 9, 2026);
        sampleName.displayName();
        sampleDate.displayDate();

        System.out.println("\n--- Hourly Employee Payroll Test ---");
        HourlyEmployee hourly1 = new HourlyEmployee(101, sampleName);
        hourly1.setBirthDate(new MyDate(18, 9, 2000));
        hourly1.setDateHired(new MyDate(1, 6, 2022));
        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);
        HourlyEmployee hourly2 = new HourlyEmployee(102, new Name("Osbev", "Cabucos"),
                new MyDate(12, 3, 1998), new MyDate(2, 1, 2023), 38, 250);
        showHourly(hourly1);
        showHourly(hourly2);

        System.out.println("\n--- Piece Worker Employee Payroll Test ---");
        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201, new Name("Carla", "Reyes"));
        piece1.setBirthDate(new MyDate(7, 4, 1999));
        piece1.setDateHired(new MyDate(15, 5, 2021));
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);
        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, new Name("David", "Santos"),
                new MyDate(21, 11, 2001), new MyDate(3, 8, 2024), 350, 12);
        showPieceWorker(piece1);
        showPieceWorker(piece2);

        System.out.println("\n--- Commission Employee Payroll Test ---");
        CommissionEmployee commission1 = new CommissionEmployee(301, new Name("Eva", "Lopez"));
        commission1.setBirthDate(new MyDate(5, 7, 1997));
        commission1.setDateHired(new MyDate(9, 2, 2020));
        commission1.setTotalSale(75000);
        CommissionEmployee commission2 = new CommissionEmployee(302, new Name("Frank", "Garcia"),
                new MyDate(30, 1, 1995), new MyDate(10, 10, 2022), 600000);
        showCommission(commission1);
        showCommission(commission2);

        System.out.println("\n--- Base Plus Commission Employee Payroll Test ---");
        BasePlusCommissionEmployee basePlus1 = new BasePlusCommissionEmployee(401, new Name("Grace", "Cruz"));
        basePlus1.setBirthDate(new MyDate(14, 2, 2000));
        basePlus1.setDateHired(new MyDate(17, 4, 2023));
        basePlus1.setTotalSale(120000);
        basePlus1.setBaseSalary(15000);
        BasePlusCommissionEmployee basePlus2 = new BasePlusCommissionEmployee(402,
                new Name("Henry", "Mendoza"), new MyDate(8, 12, 1994),
                new MyDate(25, 6, 2019), 550000, 20000);
        showBasePlus(basePlus1);
        showBasePlus(basePlus2);
    }

    private static void showHourly(HourlyEmployee employee) {
        System.out.println("\n[displayHourlyEmployee()]");
        employee.displayHourlyEmployee();
        System.out.println("[toString()]");
        System.out.println(employee);
        printPayroll(employee.getBirthDate(), employee.computeSalary(),
                employee.computeSalary(otherMonth(employee.getBirthDate())),
                employee.computeSalary(employee.getBirthDate().getMonth()));
    }

    private static void showPieceWorker(PieceWorkerEmployee employee) {
        System.out.println("\n[displayPieceWorkerEmployee()]");
        employee.displayPieceWorkerEmployee();
        System.out.println("[toString()]");
        System.out.println(employee);
        printPayroll(employee.getBirthDate(), employee.computeSalary(),
                employee.computeSalary(otherMonth(employee.getBirthDate())),
                employee.computeSalary(employee.getBirthDate().getMonth()));
    }

    private static void showCommission(CommissionEmployee employee) {
        System.out.println("\n[displayCommissionEmployee()]");
        employee.displayCommissionEmployee();
        System.out.println("[toString()]");
        System.out.println(employee);
        printPayroll(employee.getBirthDate(), employee.computeSalary(),
                employee.computeSalary(otherMonth(employee.getBirthDate())),
                employee.computeSalary(employee.getBirthDate().getMonth()));
    }

    private static void showBasePlus(BasePlusCommissionEmployee employee) {
        System.out.println("\n[displayBasePlusCommissionEmployee()]");
        employee.displayBasePlusCommissionEmployee();
        System.out.println("[toString()]");
        System.out.println(employee);
        printPayroll(employee.getBirthDate(), employee.computeSalary(),
                employee.computeSalary(otherMonth(employee.getBirthDate())),
                employee.computeSalary(employee.getBirthDate().getMonth()));
    }

    private static int otherMonth(MyDate birthDate) {
        return birthDate.getMonth() % 12 + 1;
    }

    private static void printPayroll(MyDate birthDate, double regular, double nonBirth, double birthMonth) {
        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (%s) Salary: ₱%,.2f%n",
                monthName(otherMonth(birthDate)), nonBirth);
        System.out.printf("Birth Month (%s) Salary (+₱5,000.00): ₱%,.2f%n",
                monthName(birthDate.getMonth()), birthMonth);
        if (Double.compare(regular, nonBirth) != 0 || Double.compare(birthMonth, regular + 5000) != 0) {
            throw new IllegalStateException("Birthday payroll test failed.");
        }
    }

    private static String monthName(int month) {
        return new MyDate(1, month, 2000).toString().substring(3, 6);
    }
}
