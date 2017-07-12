package weatherAPI.domain.tasks.task5;


import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.domain.tasks.sorting.SortingCore;
import weatherAPI.domain.tasks.superTask.SuperTask;

import java.util.ArrayList;

import static weatherAPI.data.constants.TagsConst.*;
import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class SortingByTempAndHumidity extends SuperTask{

    // метод для сортировки по температуре
    public ArrayList<Weather> setSomeScannerTask1Task5() {
        System.out.println(showCurrentMenu(MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG));
        int i=scannerToString();
        System.out.println(showCurrentMenu(MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION));
        int ii=scannerToString();

        Boolean isSortUp = ii == 1; // если ii==1 ->true

        switch (i){
            case 1: // сортировка по максТемп возрастание
                return SortingCore.sortingMethod(TEMP_MAX_TAG,isSortUp);
            case 2:
                return SortingCore.sortingMethod(TEMP_MIN_TAG,isSortUp);
            case 3:
                return SortingCore.sortingMethod(HUMIDITY_TAG,isSortUp);
        }

        return null;
    }
}