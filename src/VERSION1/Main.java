package VERSION1;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Hourly Employee Test ---");

        HourlyEmployee hourly1 =
                new HourlyEmployee(101, "Virna Arias");

        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        HourlyEmployee hourly2 =
                new HourlyEmployee(
                        102,
                        "Osbev Cabucos",
                        38,
                        250
                );

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();


        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);


        System.out.println();
        System.out.println("--- Piece Worker Employee Test ---");


        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(201, "Drixyl Nacu");

        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);

        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(
                        202,
                        "Zev Torrentira",
                        350,
                        12
                );

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);


        System.out.println();
        System.out.println("--- Commission Employee Test ---");


        CommissionEmployee commission1 =
                new CommissionEmployee(301, "Vera Orbello");

        commission1.setTotalSale(75000);

        CommissionEmployee commission2 =
                new CommissionEmployee(
                        302,
                        "Leira Bengil",
                        600000
                );

        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);


        System.out.println();
        System.out.println("--- Base Plus Commission Employee Test ---");


        BasePlusCommissionEmployee basePlus1 =
                new BasePlusCommissionEmployee(401, "Maruyama Tamayo");

        basePlus1.setTotalSale(120000);
        basePlus1.setBaseSalary(15000);

        // Object 2: Full constructor
        BasePlusCommissionEmployee basePlus2 =
                new BasePlusCommissionEmployee(
                        402,
                        "Loyan Aloba",
                        550000,
                        20000
                );

        System.out.println("[displayBasePlusCommissionEmployee()]");
        basePlus1.displayBasePlusCommissionEmployee();
        basePlus2.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(basePlus1);
        System.out.println(basePlus2);
    }
}