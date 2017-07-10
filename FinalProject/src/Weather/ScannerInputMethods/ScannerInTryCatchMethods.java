package Weather.ScannerInputMethods;


import Weather.EnumMessage;
import Weather.ExceptionsMessages.MyExceptions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;
import static Weather.ExceptionsMessages.MessagesControlCentre.getCountOfMethodNumber;
import static Weather.ExceptionsMessages.MenuMessages.getThisHashMapOfMessages;


public class ScannerInTryCatchMethods {

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
                    throw new MyExceptions(EnumMessage.ENTER_INTEGER);
                }
                if (getCountOfMethodNumber()!=EnumMessage.MENU_FIND_CITY_BY_RANGE_OF_TEMP) {
                    for (Map.Entry<Integer, String> entry :
                            getThisHashMapOfMessages(getCountOfMethodNumber()).entrySet())
                        if (i == entry.getKey())
                            return i;
                    throw new MyExceptions(getCountOfMethodNumber());
                }else
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
                    throw new MyExceptions(getCountOfMethodNumber());
                }
                break;
            } catch (MyExceptions e) {
                e.getRussianMessage();
                if (getCountOfMethodNumber()==EnumMessage.MENU_FIND_BY_PERIOD){
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