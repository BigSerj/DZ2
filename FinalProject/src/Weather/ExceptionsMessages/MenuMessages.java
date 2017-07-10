package Weather.ExceptionsMessages;

import Weather.EnumMessage;
import static Weather.EnumMessage.*;
import java.util.HashMap;


// класс-одиночка-хранилище всех сообщений
public class MenuMessages {

    // делаем singleton
    private static MenuMessages menuMessages = new MenuMessages();
    public static MenuMessages getInstance(){
        return menuMessages; // возвращаем уже созданный
    }




    // одностроковые сообщения
    private HashMap<EnumMessage, String> stringsMap;

    // коллекция сообщений
    private HashMap<Integer,String> mainMenuCaseParse;

    // коллекция сообщений
    private HashMap<Integer,String> mainMenuCaseTask;

    // коллекция сообщений
    private HashMap<Integer,String> menuSortingTag;

    // коллекция сообщений
    private HashMap<Integer, String> menuSortingDirection;





    // забиваем все коллекции сообщениями
    private MenuMessages() {
        stringsMap = new HashMap<>();
        stringsMap.put(MAIN_MENU_HELLO, "Здравствуйте!\n");
        stringsMap.put(ENTER_PLEASE, "Введите:\n");
        stringsMap.put(MENU_FIND_BY_DATE, "Введите число в формате: день.месяц.год. Пример: 02.03.2015");
        stringsMap.put(MENU_FIND_BY_PERIOD, "Введите искомый период \"с\"-\"по\", где первая дата меньше второй. " +
                "Формат дат: день.месяц.год\n" +
                "Пример: \nПериод с: 23.02.1988\nПериод по: 25.02.1988\n");
        stringsMap.put(MENU_FIND_BY_CITY, "Введите город из имеющихся для вывода погоды в данном городе:");
        stringsMap.put(MENU_FIND_CITY_BY_RANGE_OF_TEMP, "Введите температуру:");
        stringsMap.put(MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION,"Введите регион:");



        mainMenuCaseParse = new HashMap<>();
        mainMenuCaseParse.put(1,"-для парсинга файла .json стандартной библиотекой");
        mainMenuCaseParse.put(2,"-для парсинга файла .json библиотекой GSON");
        mainMenuCaseParse.put(3,"-для парсинга файла .xml");

        mainMenuCaseTask = new HashMap<>();
        mainMenuCaseTask.put(1,"-для вывода погоды за определенный день");
        mainMenuCaseTask.put(2,"-для вывода погоды за определенный период");
        mainMenuCaseTask.put(3,"-для вывода всего на экран");
        mainMenuCaseTask.put(4,"-для поиска погоды по определенному городу");
        mainMenuCaseTask.put(5,"-для сортировки по температуре и влажности");
        mainMenuCaseTask.put(6,"-для поиска городов по дипазону температур");
        mainMenuCaseTask.put(7,"-для выода средней, максимальной температуры по региону");

        menuSortingTag = new HashMap<>();
        menuSortingTag.put(1,"-для сортировки по максимальной температуре");
        menuSortingTag.put(2,"-для сортировки по минимальной температуре");
        menuSortingTag.put(3,"-для сортировки по влажности");

        menuSortingDirection = new HashMap<>();
        menuSortingDirection.put(1,"-для сортировки по возрастанию");
        menuSortingDirection.put(2,"-для сортировки по убыванию");
    }










    // метода для возврата нужной коллекции с сообщениями, соответствующей той, в каком меню сейчас находимся
    public static HashMap<Integer,String> getThisHashMapOfMessages(EnumMessage thisEnum){
        switch (thisEnum){
            case MAIN_MENU_SWITCH_PARSING: return getInstance().mainMenuCaseParse;
            case MAIN_MENU_SWITCH_TASK: return getInstance().mainMenuCaseTask;
            case MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG: return getInstance().menuSortingTag;
            case MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION: return getInstance().menuSortingDirection;
        }
        return null;
    }


    // метод для вызврата нужной строки, в соответствии с тем, в каком меню сейчас находимся
    public static String getThisStringOfMessage(EnumMessage thisEnum){
        return getInstance().stringsMap.get(thisEnum);
    }









}
