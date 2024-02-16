package club;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * An object representation of a valid Calendar date. Contains methods to verify
 * date and compare dates.
 *
 * @author George W Nakhla
 *
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;


    /**
     * Empty date constructor, initializes all values to 0.
     */
    public Date() {
    }


    /**
     * Date constructor with user specified values for the year, month and day.
     *
     * @param year  the year for the date object
     * @param month the month of the year for the date object
     * @param day   the dat of the month for the date object
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    /**
     * Date constructor with user specified values for the year, month and day.
     *
     * @param stringDate a string representation of a date in mm/dd/yyyy format
     */
    public Date(String stringDate) {
        // mm/dd/yyyy format
        StringTokenizer tokenizer = new StringTokenizer(stringDate ,"/");
        this.month = Integer.parseInt(tokenizer.nextToken());
        this.day = Integer.parseInt(tokenizer.nextToken());
        this.year = Integer.parseInt(tokenizer.nextToken());

    }



    /**
     * Gets the year of a target date object
     *
     * @return year return year of date object
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the month of a target date object
     *
     * @return month return month of date object
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the day of a target date object
     *
     * @return day return day of date object
     */
    public int getDay() {
        return day;
    }


    /**
     * Determines if a date is a valid calendar date
     *
     * @return boolean true if date is valid, false otherwise
     */
    public boolean isValid() {

        Calendar checkDate = Calendar.getInstance();
        checkDate.setLenient(false); // Disable leniency (to strictly enforce date validity)

        checkDate.set(Calendar.YEAR, this.getYear());
        checkDate.set(Calendar.MONTH, this.getMonth() - 1); // Note: Month is zero-based, so subtract 1 from our 1 indexed date
        checkDate.set(Calendar.DAY_OF_MONTH, this.getDay());

        try {
            checkDate.getTime(); // This call will throw an exception if the date is invalid

        } catch (Exception e) {
            return false;
        }

        if (this.getYear() < 1900) return false;

        Calendar todayDate = Calendar.getInstance();
        int todayYear = todayDate.get(Calendar.YEAR);
        int todayMonth = todayDate.get(Calendar.MONTH) + 1; // Note: Month is zero-based, so add 1
        int todayDay = todayDate.get(Calendar.DAY_OF_MONTH);

        Date currentDate = new Date(todayMonth, todayDay, todayYear);

        return this.compareTo(currentDate) != 0 && this.compareTo(currentDate) <= 0;
    }


    /**
     * Compares two dates and determines which one is greater or if they are equal.
     *
     * @param date date object to be compared
     * @return integer 0 if dates are equal, -1 if passed date is greater, 1 if passed date is smaller
     */
    @Override
    public int compareTo(Date date) {
        if (this.year != date.year) {
            return Integer.compare(this.year, date.year);
        }
        if (this.month != date.month) {
            return Integer.compare(this.month, date.month);
        }
        return Integer.compare(this.day, date.day);
    }

    /**
     * Determines the equality of 2 dates
     *
     * @param date date object to tested against
     * @return true if the dates are equal, false otherwise
     */

    public boolean equals(Date date){
        if (this.year != date.year) {
            return false;
        }
        if (this.month != date.month) {
            return false;
        }
        return this.day == date.day;
    }

    /**
     * Prints a well formatted string of the Date object
     *
     * @return A string representation of the date object
     */
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public static void main(String[] args) {
        Date test6 = new Date("2/29/2024");
        System.out.println(test6);
        System.out.println(test6.isValid());
    }


}