package weatherAPI.domain.tasks.task1;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.domain.tasks.superTask.SuperTask;

import java.util.ArrayList;

import static weatherAPI.domain.checks.Dates.getSearchDateMethod;
import static weatherAPI.domain.checks.ScannerIn.scannerStringToDate;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SetDateForSearch extends SuperTask{


    // метод для ввода искомого числа для вывода на экран
    public ArrayList<Weather> setSomeScannerTask1Task5() {
        System.out.println(showCurrentMenu(MENU_FIND_BY_DATE));

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