package weatherAPI.domain.tasks.task4;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SetCityForSearchWeather {

    // метод для поиска погоды по городу
    public static ArrayList<Weather> setCityForSearchWeather() {
        System.out.println(showCurrentMenu(MessagesConst.MENU_FIND_BY_CITY));

        ArrayList<Weather> weathers2 = new ArrayList<>();
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        // вводим город и проверяем его наличие
        while (true) {
            Scanner in = new Scanner(System.in);
            String searchCity = in.next();

            for (Weather weather : weathers) {
                ArrayList<String> location = weather.getLocation();
                for (int aLocation=0;aLocation<location.size();aLocation++) {
                    if (location.get(aLocation).startsWith(searchCity))
                        weathers2.add(weather);
                }
            }
            // если ничего не нашли
            if (weathers2.isEmpty())
                System.out.println("Данный город отсутствует в списке. Проверьте корректность ввода.");
            else break;
        }

        return weathers2;

    }


}