package weatherAPI.presentation.constants;

import java.util.ArrayList;

public enum MessagesConst {

    // константы для индексирования прерываний
    ENTER_INTEGER,
    STRING_TO_DATE_EXC,

    // константы для индексирования вызова метода
    MAIN_MENU_SWITCH_PARSING, // меню выбора парсинга xml-json
    MAIN_MENU_SWITCH_TASK, // меню выбора задания 1-7
    MENU_FIND_BY_DATE, // меню задания 1 - поиск по дате
    MENU_FIND_BY_PERIOD, // меню задания 2 - поиск по периоду времени
    MENU_FIND_BY_CITY, // меню задания 3 - поиск по названию города
    MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG,   // меню задания 4 - сортировка по температурам и влажности, выбор по чему
    MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION,   // меню задания 5 - сортировка по темп. и влажности, направление
    MENU_FIND_CITY_BY_RANGE_OF_TEMP,   // меню задания 6 - поиск города по диапазону температур
    MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION     // меню задания 7 - поиск средней и максимальной температуры по региону

}
