package Libraries.DateLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLibrary {

    public static void main(String[] args) {
        // see SimpleDateFormat documentation for more details:
        // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

        Date currentDate = new Date();
        System.out.println(currentDate); // something like Sun May 30 18:55:06 EDT 2021

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(timeFormat.format(currentDate)); // something like 06:55:06

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(currentDate)); // something like 2021/05/30

        SimpleDateFormat dayOfTheWeek = new SimpleDateFormat("EEEE");
        System.out.println(dayOfTheWeek.format(currentDate)); // something like Sunday

        // The 9 M's is to accommodate the longest month of the year with 9 letters.
        SimpleDateFormat monthOfTheYear = new SimpleDateFormat("MMMMMMMMM");
        System.out.println(monthOfTheYear.format(currentDate)); // something like May

        SimpleDateFormat clockFormat = new SimpleDateFormat("h:mm:ss a");
        System.out.println(clockFormat.format(currentDate)); // something like 6:55:06 p.m.
    }
}
