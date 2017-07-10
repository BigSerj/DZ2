package Weather.ScannerInputMethods;


import Weather.ExceptionsMessages.MessagesControlCentre;
import Weather.*;
import java.util.*;
import static Weather.DateMethods.*;
import static Weather.ExceptionsMessages.MessagesControlCentre.*;
import static Weather.ScannerInputMethods.ScannerInTryCatchMethods.scannerStringToDate;


public class SetDatePeriodForSearch {


    // метод поиска диапазона дат
    public static ArrayList<Weather> setDatePeriodForSearch() {
        System.out.println(sbMethod(EnumMessage.MENU_FIND_BY_PERIOD));

        // проверяем корректность ввода даты
        System.out.print("Период с: ");
        String searchDate1 = scannerStringToDate(1);
        System.out.print("Период по: ");
        String searchDate2 = scannerStringToDate(0);

        // создаем коллекцию weathers2 из подходяших под условие поиска элементов коллекции weathers
        ArrayList<Weather> weathers = Root.getInstance().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (!weather.getDate().equals(MessagesControlCentre.DATE_WRONG_FORMAT) &&
                    convertStringToDate2(searchDate1).before(convertStringToDate(weather.getDate())) &&
                    convertStringToDate2(searchDate2).after(convertStringToDate(weather.getDate()))) {
                weather.getDate();
                weathers2.add(weather);
            }
        }
        return weathers2;
    }

}
