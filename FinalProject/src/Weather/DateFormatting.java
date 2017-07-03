package Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting {
    
    public static String convertDate(String dateOld){

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(dateOld);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new SimpleDateFormat("EEEE, HH:mm:ss, dd MMMM yyyy. zzzz").format(date);
    }
}