package weatherAPI.domain.tasks.task6;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;

import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SearchCityByRangeOfTemp {

    public static ArrayList<String> searchCityByRangeOfTemp() {
        System.out.println(showCurrentMenu(MessagesConst.MENU_FIND_CITY_BY_RANGE_OF_TEMP));

        // вводим искомую температуру
        int searchTemp = scannerToString();

        ArrayList<String> location = new ArrayList<>();
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        // прогоняем каждый элемент weather`а
        for (int i=0;i<weathers.size();i++){
            // если температура входит в диапазон температур элемента
            if (searchTemp>=weathers.get(i).getTempMin() && searchTemp<=weathers.get(i).getTempMax()){
                // прогоняем каждый город элемента
                for (int j=0;j<weathers.get(i).getLocation().size();j++) {
                    Boolean thisCycleBreak = false;
                    // прогоняем каждый элемент нового массива городов
                    for (String aLocation : location) {
                        if (aLocation.equals(weathers.get(i).getLocation().get(j))) {
                            thisCycleBreak = true;
                            break;
                        }
                    }
                    // выходим если город уже встречался ранее
                    if (thisCycleBreak)
                        break;
                    // если небыло такого города - запоминаем
                    location.add(weathers.get(i).getLocation().get(j));
                }
            }
        }
        if (location.isEmpty())
            location.add("Нет городов с искомой температурой.");
        return location;
    }



}