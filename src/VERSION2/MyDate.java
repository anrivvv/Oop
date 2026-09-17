package VERSION2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month; // 1-12
    private int year; 

    public MyDate() {
        this(1, 1, 2000);
    }

    //full constructor with boundary checks for month and day
    public MyDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException exception) {
            throw new IllegalArgumentException("Invalid calendar date.", exception);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
   
    //Getters 
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void displayDate() {
        System.out.println("Date: " + this);
    }

    @Override
    public String toString() {
        return LocalDate.of(year, month, day)
                .format(DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH));
    }   


}
