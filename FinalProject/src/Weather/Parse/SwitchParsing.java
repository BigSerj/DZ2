package Weather.Parse;

import Weather.MyExceptions;
import java.util.Scanner;


public class SwitchParsing extends MyExceptions{

    public SwitchParsing(int codeEx) {
        super(codeEx);
    }

    // метод в котором идет ввод данных с клавиатуры с обработкой ошибок,
    // а также в зависимости от выбранного способа парсинга возвращается соотв. объект
    public static Parse switchParsingMethod(){
        int i;
        // пока не будет введено корректное значение - не выйдем из цикла
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            // ловим возможные исключения, и выводим их на экран через свой соотв. метод в своих исключениях
            try {
                try {
                    i = Integer.parseInt(s);
                } catch (Exception e) {
                    // если введена не цифра - исключение 1
                    throw new MyExceptions(1);
                }
                if (i < 1 || i > 3)
                    // если введена цифра не 1 не 2 и не 3 - исключение 2
                    throw new MyExceptions(2);
                break;
            }catch (MyExceptions e){
                // ловим тут и передаем на вывод на экран
                e.getRussianMessage();
            }
        }
        // В зависимости от выбранного вида парсинга создаем соотв. объект и возвращаем его в Main
        switch (i) {
            case 1: return new JSONParse();
            case 2: return new GSONParse();
            case 3: return new ParseXML();
        }
        return null;
    }

}
