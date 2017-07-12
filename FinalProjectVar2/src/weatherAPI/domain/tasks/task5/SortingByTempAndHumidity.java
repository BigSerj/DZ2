package weatherAPI.domain.tasks.task5;


import weatherAPI.data.constants.TagsConst;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.domain.tasks.task7.SortingCore;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;

import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SortingByTempAndHumidity{

    // метод для сортировки по температуре
    public static ArrayList<Weather> sortingByTempAndHumidity() {
        System.out.println(showCurrentMenu(MessagesConst.MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG));
        int i=scannerToString();
        System.out.println(showCurrentMenu(MessagesConst.MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION));
        int ii=scannerToString();

        Boolean isSortUp = ii == 1; // если ii==1 ->true

        switch (i){
            case 1: // сортировка по максТемп возрастание
                return SortingCore.sortingMethod(TagsConst.TEMP_MAX_TAG,isSortUp);
            case 2:
                return SortingCore.sortingMethod(TagsConst.TEMP_MIN_TAG,isSortUp);
            case 3:
                return SortingCore.sortingMethod(TagsConst.HUMIDITY_TAG,isSortUp);
        }

        return null;
    }
}