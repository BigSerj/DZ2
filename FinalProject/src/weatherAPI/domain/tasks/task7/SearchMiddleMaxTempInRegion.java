package weatherAPI.domain.tasks.task7;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;
import java.util.Scanner;


import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SearchMiddleMaxTempInRegion {

    public static Integer[] searchMiddleMaxTempInRegion(){
        System.out.println(showCurrentMenu(MessagesConst.MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION));

        // вводим искомый регион
        String searchRegion = new Scanner(System.in).next();

        Integer[] middleMaxTemp = new Integer[2];
        middleMaxTemp[0]=-999;
        middleMaxTemp[1]=-999;
        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        // прогоняем каждый элемент weather`а
        for (int i=0;i<weathers.size();i++){
            // если нашли регион, который вводили, и температуры элементов корректные - рассчитываем
            if (weathers.get(i).getLocation().get(0).endsWith(searchRegion) && weathers.get(i).getTempMax()!=-999
                    && weathers.get(i).getTempMin()!=-999){
                // если считаем первый раз
                if (middleMaxTemp[0]==-999){
                    middleMaxTemp[0]=(weathers.get(i).getTempMax() + weathers.get(i).getTempMin()) / 2;
                    middleMaxTemp[1]=weathers.get(i).getTempMax();
                // если творой и более
                }else {
                    // находим среднюю температуру
                    middleMaxTemp[0] = (middleMaxTemp[0] + (weathers.get(i).getTempMax() +
                            weathers.get(i).getTempMin()) / 2) / 2;
                    // находим максимальную температуру
                    if (weathers.get(i).getTempMax() > middleMaxTemp[1])
                        middleMaxTemp[1] = weathers.get(i).getTempMax();
                }
            }
        }
        return middleMaxTemp;
    }
}