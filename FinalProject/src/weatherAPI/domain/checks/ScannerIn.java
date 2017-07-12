package weatherAPI.domain.checks;


import weatherAPI.presentation.exceptions.MyExceptions;
import weatherAPI.presentation.menu.ControlCentreMenu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.getCurrentMenu;


public class ScannerIn {

    // метод корректности ввода с клавиатуры правильного значения Integer
    public static int scannerToString() {
        while (true) {
            int i;
            // ловим возможные исключения, и выводим их на экран через свой соотв. метод в своих исключениях
            try {
                try {
                    i = Integer.parseInt(new Scanner(System.in).next());
                } catch (Exception e) {
                    // если введена не цифра - исключение 1
                    throw new MyExceptions(ENTER_INTEGER);
                }
                // если мы не в меню нахождения по диапазону температур
                if (getCurrentMenu() != MENU_FIND_CITY_BY_RANGE_OF_TEMP &&
                        i < 1 || i > ControlCentreMenu.getInstance().getMessagesListInHashMap().getHashMapOfMessages()
                        .get(getCurrentMenu()).size())
                        throw new MyExceptions(getCurrentMenu());
                else
                    return i;
            } catch (MyExceptions e) {
                // ловим тут и передаем на вывод на экран
                e.getRussianMessage();
            }
        }
    }


    // метод корректности ввода с клавиатуры правильного значения Date
    public static String scannerStringToDate(int dateX){
        String inDate;
        while (true) {
            Scanner in = new Scanner(System.in);
            inDate = in.next();
            try {
                try {
                    new SimpleDateFormat("dd.MM.yyyy").parse(inDate);
                } catch (ParseException e) {
                    throw new MyExceptions(getCurrentMenu());
                }
                break;
            } catch (MyExceptions e) {
                e.getRussianMessage();
                if (getCurrentMenu()== MENU_FIND_BY_PERIOD){
                    if (dateX==1)
                        System.out.print("Период с: ");
                    else
                        System.out.print("Период по: ");
                }
            }
        }
        return inDate;
    }
}