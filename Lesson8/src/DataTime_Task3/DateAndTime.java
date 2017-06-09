package DataTime_Task3;

// Июнь 5e, 9:00 PM    (пятое)

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateAndTime {

    public static void main(String[] args) {

        GregorianCalendar nowDate = new GregorianCalendar();
        Date date = nowDate.getTime();


        SimpleDateFormat format1 = new SimpleDateFormat("MMMM d", Locale.getDefault());
        SimpleDateFormat format2 = new SimpleDateFormat("h:mm a", Locale.getDefault());

        StringBuilder sb = new StringBuilder();

        sb.append(format1.format(date));
        sb.append("е, ");
        sb.append(format2.format(date));

        System.out.println(sb.toString());

    }
}
