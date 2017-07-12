package weatherAPI.presentation.menu;


import weatherAPI.presentation.constants.MessagesConst;

import static weatherAPI.presentation.menu.Constants.*;


final public class ControlCentreMenu {

    // делаем управление сообщениями singleton
    private static ControlCentreMenu controlCentreMenu = new ControlCentreMenu();
    public static ControlCentreMenu getInstance(){
        menuMessages = new EntityOfMenuMessages();
        return controlCentreMenu; // возвращаем уже созданный
    }

    // переменная для запоминания того, в каком меню мы сейчас находимся
    private static MessagesConst memoryOfMenu;
    public static MessagesConst getCurrentMenu() {
        return memoryOfMenu;
    }

    // экземпляр класса-хранилки сообщений
    private static EntityOfMenuMessages menuMessages;
    public EntityOfMenuMessages getMessagesListInHashMap() {
        return menuMessages;
    }



    // метод для сообщений, которые используются повторно, могут быть составными частями большего сообщения
    public static StringBuffer showCurrentMenu(MessagesConst switchMethod){
        memoryOfMenu = switchMethod; // запомниаем в каком меню мы сейчас

        StringBuffer sb = new StringBuffer();
        sb.append(n+VISUAL_SEPARATOR+n);

        if (menuMessages.getHashMapOfMessages().get(switchMethod).size()>1) { // если длина более 1
            sb.append(ENTER_PLEASE).append(ENTER_PLEASE_COLON).append(n);  // Введите:
            for (int i = 0; i < menuMessages.getHashMapOfMessages().get(switchMethod).size(); i++)
                // то выводим (порядковый номер)+1 и значение
                sb.append(i + 1).append(menuMessages.getHashMapOfMessages().get(switchMethod).get(i)).append(n);
        }else {    // если это строка
            // то выводим только значение
            sb.append(ENTER_PLEASE).append(ENTER_PLEASE_SPACE).append(menuMessages.getHashMapOfMessages().get(switchMethod).get(0)).append(n);
        }
        return sb;
    }
}