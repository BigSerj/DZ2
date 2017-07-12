package weatherAPI.domain.tasks.task2;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;
import weatherAPI.presentation.menu.Constants;

import java.util.*;
import static weatherAPI.domain.checks.DatesFormat.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.*;
import static weatherAPI.domain.checks.ScannerIn.scannerStringToDate;


public class SetDatePeriodForSearch {


    // метод поиска диапазона дат
    public static ArrayList<Weather> setDatePeriodForSearch() {
        System.out.println(showCurrentMenu(MessagesConst.MENU_FIND_BY_PERIOD));

        // проверяем корректность ввода даты
        System.out.print("Период с: ");
        String searchDate1 = scannerStringToDate(1);
        System.out.print("Период по: ");
        String searchDate2 = scannerStringToDate(0);

        // создаем коллекцию weathers2 из подходяших под условие поиска элементов коллекции weathers
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (!weather.getDate().equals(Constants.DATE_WRONG_FORMAT) &&
                    convertStringToDate2(searchDate1).before(convertStringToDate(weather.getDate())) &&
                    convertStringToDate2(searchDate2).after(convertStringToDate(weather.getDate()))) {
                weather.getDate();
                weathers2.add(weather);
            }
        }
        return weathers2;
    }

}
