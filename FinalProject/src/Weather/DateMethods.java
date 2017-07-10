package Weather;


import Weather.ExceptionsMessages.*;
import java.text.*;
import java.util.Date;
import java.util.regex.Pattern;


public class DateMethods {

    // метод перевода из Date в нужный вид String
    public static String convertDate(String dateOld) {
        if (!dateOld.equals(MessagesControlCentre.DATE_WRONG_FORMAT))
            return new SimpleDateFormat("EEEE, HH:mm:ss, dd MMMM yyyy. zzz").format(convertStringToDate(dateOld));
        return MessagesControlCentre.DATE_WRONG_FORMAT;
    }


    // метод для поиска введенного дня недели, возвращает дату в нужном формате
    public static String getSearchDateMethod(String date) {
        if (!date.equals(MessagesControlCentre.DATE_WRONG_FORMAT))
            return new SimpleDateFormat("dd.MM.yyyy").format(convertStringToDate(date));
        return MessagesControlCentre.DATE_WRONG_FORMAT;
    }

    // конвертер формата даты из String в Date
    public static Date convertStringToDate(String dateOld) {
        try {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(dateOld);
            } catch (ParseException e) {
                throw new MyExceptions(EnumMessage.STRING_TO_DATE_EXC);
            }
        } catch (MyExceptions e) {
            e.getRussianMessage();
            return null;
        }
    }

    // метод конвертации даты из String в формат Date день.месяц.год
    public static Date convertStringToDate2(String dateOld) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateOld);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    // метод проверки даты регулярным выражением на соответствие регламенту
    public static String checkDate(String date){
        Pattern p = Pattern.compile("^[0-9]{4}-[0-1][0-9]-[0-3][0-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\s(\\+|-)[0-9]{1,4}");
        if (p.matcher(date).matches())
            return date;
        return MessagesControlCentre.DATE_WRONG_FORMAT;
    }


}