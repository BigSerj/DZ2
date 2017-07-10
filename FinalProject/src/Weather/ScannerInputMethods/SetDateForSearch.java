package Weather.ScannerInputMethods;


import Weather.*;
import java.util.ArrayList;
import static Weather.DateMethods.getSearchDateMethod;
import static Weather.ExceptionsMessages.MessagesControlCentre.*;
import static Weather.ScannerInputMethods.ScannerInTryCatchMethods.scannerStringToDate;


public class SetDateForSearch {


    // метод для ввода искомого числа для вывода на экран
    public static ArrayList<Weather> setDateForSearch() {
        System.out.println(sbMethod(EnumMessage.MENU_FIND_BY_DATE));

        // проверяем корректность ввода даты
        String inDate = scannerStringToDate(0);

        // создаем коллекцию weathers2 из подходяших под условие поиска элементов коллекции weathers
        ArrayList<Weather> weathers = Root.getInstance().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (inDate.equals(getSearchDateMethod(weather.getDate())))
                weathers2.add(weather);
        }
        return weathers2;
    }


}