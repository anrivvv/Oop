package VERSION5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() { this(1, 1, 2000); }
    public MyDate(int day, int month, int year) { setDate(day, month, year); }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public final void setDay(int day) { setDate(day, month, year); }
    public final void setMonth(int month) { setDate(day, month, year); }
    public final void setYear(int year) { setDate(day, month, year); }
    public final void setDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException exception) {
            throw new IllegalArgumentException("Invalid calendar date.", exception);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void displayDate() { System.out.println("Date: " + this); }

    @Override
    public String toString() {
        return LocalDate.of(year, month, day)
                .format(DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate other)) return false;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() { return Objects.hash(day, month, year); }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
