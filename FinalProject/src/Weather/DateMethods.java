package Weather;

import Weather.ExceptionsMessages.MyExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateMethods {

    // метод перевода из Date в нужный вид String
    public static String convertDate(String dateOld) {
        return new SimpleDateFormat("EEEE, HH:mm:ss, dd MMMM yyyy. zzz").format(convertStringToDate(dateOld));
    }


    // метод для поиска введенного дня недели, возвращает дату в нужном формате
    public static String getSearchDateMethod(String date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(convertStringToDate(date));
    }

    // конвертер формата даты из String в Date
    public static Date convertStringToDate(String dateOld) {
        try {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(dateOld);
            } catch (ParseException e) {
                throw new MyExceptions(101);
            }
        } catch (MyExceptions e) {
            e.getRussianMessage();
            return null;
        }
    }


    public static Date convertStringToDate2(String dateOld) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateOld);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}