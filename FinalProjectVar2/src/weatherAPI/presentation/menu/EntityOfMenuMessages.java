package weatherAPI.presentation.menu;


import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;
import java.util.HashMap;

import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.MenuMessages.*;


// класс-хранилище всех сообщений в виде HashMap
public class EntityOfMenuMessages {

    private HashMap<MessagesConst, ArrayList<String>> hashMapOfMessages = new HashMap<>();
    public HashMap<MessagesConst, ArrayList<String>> getHashMapOfMessages() {
        return hashMapOfMessages;
    }

    // забиваем все коллекции сообщениями
    public EntityOfMenuMessages() {

        // создаем объект с листами сообщений
        hashMapOfMessages.put(MAIN_MENU_SWITCH_PARSING,forConstructorParse());
        hashMapOfMessages.put(MAIN_MENU_SWITCH_TASK,forConstructorTask());
        hashMapOfMessages.put(MENU_FIND_BY_DATE,forFindByDate());
        hashMapOfMessages.put(MENU_FIND_BY_PERIOD,forFindByPeriod());
        hashMapOfMessages.put(MENU_FIND_BY_CITY,forFindByCity());
        hashMapOfMessages.put(MENU_FIND_CITY_BY_RANGE_OF_TEMP,forFindCityByRangeOfTemp());
        hashMapOfMessages.put(MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION,forFindMiddleMaxTempInRegion());
        hashMapOfMessages.put(MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG,forConstructorTag());
        hashMapOfMessages.put(MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION,forConstructorDirection());
    }
}