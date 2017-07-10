package Weather.ScannerInputMethods;


import Weather.EnumMessage;
import Weather.*;
import java.util.ArrayList;
import static Weather.ExceptionsMessages.MessagesControlCentre.sbMethod;
import static Weather.ScannerInputMethods.ScannerInTryCatchMethods.scannerToString;


public class SearchCityByRangeOfTemp {

    public static ArrayList<String> searchCityByRangeOfTemp() {
        System.out.println(sbMethod(EnumMessage.MENU_FIND_CITY_BY_RANGE_OF_TEMP));

        // вводим искомую температуру
        int searchTemp = scannerToString();

        ArrayList<String> location = new ArrayList<>();
        ArrayList<Weather> weathers = Root.getInstance().getWeather();
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