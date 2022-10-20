package games.platform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateParser {

    private static final String DATABASE_FORMAT = "yyyy-MM-dd";
    private static final String BRAZILIAN_FORMAT = "dd/MM/yyyy";

    private static String parseDateToFormat(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String dateParsed = formatter.format(date);
        return dateParsed;
    }

    /**
     * Parse a Date object to the follow format yyyy-MM-dd
     *
     * @param date date to be parsed
     * @return string with date formatted
     */
    public static String parseDateToDatabaseFormat(Date date) {
        if (date == null) {
            return "";
        }

        return parseDateToFormat(date, DATABASE_FORMAT);
    }

    /**
     * Parse a Date formatted as yyyy-MM-dd to a Date object
     *
     * @param date date formatted to be parsed
     * @return date from formatted string
     */
    public static Date parseDateFromDatabaseFormat(String date) {
        Date dateParsed;
        try {
            dateParsed = new SimpleDateFormat(DATABASE_FORMAT).parse(date);
        } catch (ParseException ex) {
            return null;
        }
        return dateParsed;
    }

    /**
     * Parse a Date object to the follow format yyyy-MM-dd
     *
     * @param date date to be parsed
     * @return string with date formatted
     */
    public static String parseDateToBrazilianFormat(Date date) {
        if (date == null) {
            return "";
        }

        return parseDateToFormat(date, BRAZILIAN_FORMAT);
    }

}
