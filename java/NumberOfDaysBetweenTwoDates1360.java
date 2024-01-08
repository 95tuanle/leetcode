package java;//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;

/*
Write a program to count the number of days between two dates.
The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
*/
public class NumberOfDaysBetweenTwoDates1360 {
    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }

    public static int daysBetweenDates(String date1, String date2) {
        return Math.abs(totalDays(date1) - totalDays(date2));

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate1 = LocalDate.parse(date1, formatter);
//        LocalDate localDate2 = LocalDate.parse(date2, formatter);
//        return Math.abs((int) ChronoUnit.DAYS.between(localDate1, localDate2));

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date parsedDate1 = simpleDateFormat.parse(date1);
//            Date parsedDate2 = simpleDateFormat.parse(date2);
//            long differenceInMilliseconds = Math.abs(parsedDate1.getTime() - parsedDate2.getTime());
//            return (int) TimeUnit.DAYS.convert(differenceInMilliseconds, TimeUnit.MILLISECONDS);
//        } catch (ParseException parseException) {
//            System.out.println("Exception occurred while parsing the date: " + parseException.getMessage());
//        }
//        return 0;
    }

    public static int totalDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int days = Integer.parseInt(date.substring(8, 10));
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) days += months[i];
        days += (year - 1) * 365;
        days += (year - 1) / 4;
        if (year % 4 == 0 && month > 2 && year != 2100) days++;
        return days;
    }
}
