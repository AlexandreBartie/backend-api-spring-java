package br.com.bartie.app.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    public static Date getDate(int daysToAdd) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Add the specified number of days to the current date
        LocalDate targetDate = currentDate.plusDays(daysToAdd);

        // Convert the target date to a Date object
        Date date = Date.from(targetDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Return the Date object
        return date;
    }
}