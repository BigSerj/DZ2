package weatherAPI.domain.tasks.task2;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.domain.tasks.superTask.SuperTask;
import java.util.ArrayList;

import static weatherAPI.domain.checks.Dates.convertStringToDate;
import static weatherAPI.domain.checks.Dates.convertStringToDate2;
import static weatherAPI.domain.checks.ScannerIn.scannerStringToDate;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.Constants.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SetDatePeriodForSearch extends SuperTask{


    // метод поиска диапазона дат
    public ArrayList<Weather> setSomeScannerTask1Task5() {
        System.out.println(showCurrentMenu(MENU_FIND_BY_PERIOD));

        // проверяем корректность ввода даты
        System.out.print("Период с: ");
        String searchDate1 = scannerStringToDate(1);
        System.out.print("Период по: ");
        String searchDate2 = scannerStringToDate(0);

        // создаем коллекцию weathers2 из подходяших под условие поиска элементов коллекции weathers
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (!weather.getDate().equals(DATE_WRONG_FORMAT) &&
                    convertStringToDate2(searchDate1).before(convertStringToDate(weather.getDate())) &&
                    convertStringToDate2(searchDate2).after(convertStringToDate(weather.getDate()))) {
                weathers2.add(weather);
            }
        }
        return weathers2;
    }

}
