package weatherAPI.domain.tasks.task7;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;

import java.util.ArrayList;
import java.util.Scanner;

import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SearchMiddleMaxTempInRegion {

    public Integer[] searchMiddleMaxTempInRegion(){
        System.out.println(showCurrentMenu(MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION));

        // вводим искомый регион
        String searchRegion = new Scanner(System.in).next();

        Integer[] middleMaxTemp = new Integer[2];
        middleMaxTemp[0]=-999;
        middleMaxTemp[1]=-999;
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        // прогоняем каждый элемент weather`а
        for (Weather weather : weathers) {
            // если нашли регион, который вводили, и температуры элементов корректные - рассчитываем
            if (weather.getLocation().get(0).endsWith(searchRegion) && weather.getTempMax() != -999
                    && weather.getTempMin() != -999) {
                // если считаем первый раз
                if (middleMaxTemp[0] == -999) {
                    middleMaxTemp[0] = (weather.getTempMax() + weather.getTempMin()) / 2;
                    middleMaxTemp[1] = weather.getTempMax();
                    // если творой и более
                } else {
                    // находим среднюю температуру
                    middleMaxTemp[0] = (middleMaxTemp[0] + (weather.getTempMax() +
                            weather.getTempMin()) / 2) / 2;
                    // находим максимальную температуру
                    if (weather.getTempMax() > middleMaxTemp[1])
                        middleMaxTemp[1] = weather.getTempMax();
                }
            }
        }
        return middleMaxTemp;
    }
}