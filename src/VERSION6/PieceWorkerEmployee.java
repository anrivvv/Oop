package VERSION6;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() { super(); }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public double getRatePerPiece() { return ratePerPiece; }
    public final void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) throw new IllegalArgumentException("Pieces must be finite and non-negative.");
        this.totalPiecesFinished = totalPiecesFinished;
    }
    public final void setRatePerPiece(double ratePerPiece) {
        if (!Double.isFinite(ratePerPiece) || ratePerPiece < 0) throw new IllegalArgumentException("Piece rate must be finite and non-negative.");
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary() { return computeSalary(-1); }

    @Override
    public void displayEmployee() { System.out.println(this); }

    @Override
    public double computeSalary(int currentMonth) {
        double piecePay = totalPiecesFinished * ratePerPiece;
        double productionBonus = (totalPiecesFinished / 100) * 10 * ratePerPiece;
        return piecePay + productionBonus + getBirthdayBonus(currentMonth);
    }

    public void displayPieceWorkerEmployee() { displayEmployee(); }

    @Override
    public String toString() {
        return String.format(java.util.Locale.ENGLISH, "PieceWorkerEmployee [%s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                super.toString(), totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }

    @Override
    public PieceWorkerEmployee clone() { return (PieceWorkerEmployee) super.clone(); }
}
