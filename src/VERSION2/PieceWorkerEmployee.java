package VERSION2;

public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() { this(0, new Name(), new MyDate(), new MyDate(), 0, 0); }
    public PieceWorkerEmployee(int empID, Name empName) { this(empID, empName, new MyDate(), new MyDate(), 0, 0); }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0, 0);
    }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }
    public int getEmpID() { return empID; }
    public Name getEmpName() { return empName; }
    public MyDate getBirthDate() { return birthDate; }
    public MyDate getDateHired() { return dateHired; }
    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public double getRatePerPiece() { return ratePerPiece; }
    public void setEmpID(int empID) { this.empID = empID; }
    public void setEmpName(Name empName) { this.empName = empName; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) this.totalPiecesFinished = totalPiecesFinished;
    }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) this.ratePerPiece = ratePerPiece;
    }
    public double computeSalary() {
        return totalPiecesFinished * ratePerPiece + (totalPiecesFinished / 100) * 10 * ratePerPiece;
    }
    public double computeSalary(int currentMonth) {
        return computeSalary() + (birthDate != null && birthDate.getMonth() == currentMonth ? 5000 : 0);
    }
    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%,.2f%n",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece);
    }
    @Override public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
