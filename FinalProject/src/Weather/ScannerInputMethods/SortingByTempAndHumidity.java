package Weather.ScannerInputMethods;


import Weather.*;
import java.util.*;
import static Weather.ExceptionsMessages.MessagesControlCentre.sbMethod;
import static Weather.ScannerInputMethods.ScannerInTryCatchMethods.scannerToString;


public class SortingByTempAndHumidity{

    // метод для сортировки по температуре
    public static ArrayList<Weather> sortingByTempAndHumidity() {
        System.out.println(sbMethod(EnumMessage.MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG));
        int i=scannerToString();
        System.out.println(sbMethod(EnumMessage.MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION));
        int ii=scannerToString();

        Boolean isSortUp = ii == 1; // если ii==1 ->true

        switch (i){
            case 1: // сортировка по максТемп возрастание
                return SortMethodCore.sortingMethod(Constants.TEMP_MAX_TAG,isSortUp);
            case 2:
                return SortMethodCore.sortingMethod(Constants.TEMP_MIN_TAG,isSortUp);
            case 3:
                return SortMethodCore.sortingMethod(Constants.HUMIDITY_TAG,isSortUp);
        }

        return null;
    }
}