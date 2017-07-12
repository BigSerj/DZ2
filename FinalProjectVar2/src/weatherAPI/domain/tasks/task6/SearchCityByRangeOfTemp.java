package weatherAPI.domain.tasks.task6;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;

import java.util.ArrayList;

import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SearchCityByRangeOfTemp {

    public ArrayList<String> searchCityByRangeOfTemp() {
        System.out.println(showCurrentMenu(MENU_FIND_CITY_BY_RANGE_OF_TEMP));

        // вводим искомую температуру
        int searchTemp = scannerToString();

        ArrayList<String> location = new ArrayList<>();
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        // прогоняем каждый элемент weather`а
        for (Weather weather : weathers) {
            // если температура входит в диапазон температур элемента
            if (searchTemp >= weather.getTempMin() && searchTemp <= weather.getTempMax()) {
                // прогоняем каждый город элемента
                for (int j = 0; j < weather.getLocation().size(); j++) {
                    Boolean thisCycleBreak = false;
                    // прогоняем каждый элемент нового массива городов
                    for (String aLocation : location) {
                        if (aLocation.equals(weather.getLocation().get(j))) {
                            thisCycleBreak = true;
                            break;
                        }
                    }
                    // выходим если город уже встречался ранее
                    if (thisCycleBreak)
                        break;
                    // если небыло такого города - запоминаем
                    location.add(weather.getLocation().get(j));
                }
            }
        }
        return location;
    }



}