package weatherAPI.domain.tasks.task1;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;
import static weatherAPI.domain.checks.DatesFormat.getSearchDateMethod;
import static weatherAPI.presentation.menu.ControlCentreMenu.*;
import static weatherAPI.domain.checks.ScannerIn.scannerStringToDate;


public class SetDateForSearch {


    // метод для ввода искомого числа для вывода на экран
    public static ArrayList<Weather> setDateForSearch() {
        System.out.println(showCurrentMenu(MessagesConst.MENU_FIND_BY_DATE));

        // проверяем корректность ввода даты
        String inDate = scannerStringToDate(0);

        // создаем коллекцию weathers2 из подходяших под условие поиска элементов коллекции weathers
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (inDate.equals(getSearchDateMethod(weather.getDate())))
                weathers2.add(weather);
        }
        return weathers2;
    }


}