package Weather.ExceptionsMessages;


import Weather.EnumMessage;

import java.util.HashMap;
import java.util.Map;
import static Weather.EnumMessage.*;
import static Weather.ExceptionsMessages.MenuMessages.*;


final public class MessagesControlCentre {

    // сообщение о том, что дата передана в не корректном формате
    public static final String DATE_WRONG_FORMAT = "Неверный формат даты.";
    public static final String VISUAL_SEPARATOR = "=================================================================" +
            "=======================================================";
    private static final String n = "\n";

    // переменная для запоминания того, в какой части меню мы сейчас находимся
    private static EnumMessage countOfScannerInput;
    public static EnumMessage getCountOfMethodNumber() {
        return countOfScannerInput;
    }


    // метод для сообщений, которые используются повторно, могут быть составными частями большего сообщения
    public static StringBuffer sbMethod(EnumMessage switchMethod){
        countOfScannerInput = switchMethod;

        StringBuffer sb = new StringBuffer();
        sb.append(n+VISUAL_SEPARATOR+n);
        switch (switchMethod){
            case MAIN_MENU_HELLO:
            case MENU_FIND_BY_DATE:
            case MENU_FIND_BY_PERIOD:
            case MENU_FIND_BY_CITY:
            case MENU_FIND_CITY_BY_RANGE_OF_TEMP:
            case MENU_FIND_MIDDLE_MAX_TEMP_IN_REGION:
                return sb.append(getThisStringOfMessage(switchMethod));
            case MAIN_MENU_SWITCH_PARSING:
            case MAIN_MENU_SWITCH_TASK:
            case MENU_SORTING_BY_TEMP_AND_HUMIDITY_TAG:
            case MENU_SORTING_BY_TEMP_AND_HUMIDITY_DIRECTION:
                return sbIn(getThisHashMapOfMessages(switchMethod),sb);
        }
        return sb;
    }



    // метод компоновки сообщения из коллекции меню
    private static StringBuffer sbIn(HashMap<Integer,String> caseThis, StringBuffer sb){
        sb.append(getThisStringOfMessage(ENTER_PLEASE));  // Введите:
        for(Map.Entry<Integer, String> entry : caseThis.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue()).append(n);
        }
        return sb;
    }

    // для визуального умньшения кол-ва символов в коде:
    private static MenuMessages getMess(){
        return MenuMessages.getInstance();
    }

}
