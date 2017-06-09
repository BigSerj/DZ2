package ConversionDate_Task4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conv {

    public static void main(String[] args)  throws ParseException {
        String dateStr = "2017-06-05 20:25";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date docDate = format.parse(dateStr);
        System.out.println(docDate);
    }

}
