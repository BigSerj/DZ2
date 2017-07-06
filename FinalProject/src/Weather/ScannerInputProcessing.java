package Weather;

import Weather.ExceptionsMessages.MyExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static Weather.DateMethods.*;
import static Weather.ExceptionsMessages.LoopedMessages.*;


public class ScannerInputProcessing extends MyExceptions {

    public ScannerInputProcessing(int codeEx) {
        super(codeEx);
    }

    // метод в котором идет ввод данных с клавиатуры с обработкой ошибок,
    public static Integer switch123() {
        // пока не будет введено корректное значение - не выйдем из цикла
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            // ловим возможные исключения, и выводим их на экран через свой соотв. метод в своих исключениях
            try {
                int i;
                try {
                    i = Integer.parseInt(s);
                } catch (Exception e) {
                    // если введена не цифра - исключение 1
                    throw new MyExceptions(1);
                }
                // если вводим несоответствющие диапазоны запросов
                if (((i < 1 || i > 3) && getCountOfScannerInput()==2) || ((i < 1 || i > 8) && getCountOfScannerInput()==3))
                    throw new MyExceptions(getCountOfScannerInput());
                return i;
            } catch (MyExceptions e) {
                // ловим тут и передаем на вывод на экран
                e.getRussianMessage();
            }
        }
    }




    // метод для ввода искомого числа для вывода на экран
    public static String setDateForSearch() {
        System.out.println(sbMethod(4));

        String inDate;
        // проверяем корректность ввода даты
        while (true) {
            Scanner in = new Scanner(System.in);
            inDate = in.next();
            try {
                try {
                    new SimpleDateFormat("dd.MM.yyyy").parse(inDate);
                } catch (ParseException e) {
                    throw new MyExceptions(getCountOfScannerInput());
                }
                break;
            } catch (MyExceptions e) {
                e.getRussianMessage();
            }
        }

        ArrayList<Weather> weathers = Root.getInstance().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (inDate.equals(getSearchDateMethod(weather.getDate())))
                weathers2.add(weather);
        }
        return "Root (name=" + Root.getInstance().getName() + ", date=" +
                convertDate(Root.getInstance().getDate())+ ",weather=" + weathers2 + ")";
    }

/*
02.03.2015
 */


    // метод поиска диапазона дат
    public static String setDatePeriodForSearch() {
        System.out.println(sbMethod(5));
        String searchDate1;
        String searchDate2;

        // проверяем корректность ввода даты
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Период с: ");
            searchDate1 = in.next();
            System.out.print("Период по: ");
            searchDate2 = in.next();

            try {
                Date d1;
                Date d2;
                try {
                    d1 = new SimpleDateFormat("dd.MM.yyyy").parse(searchDate1);
                } catch (Exception e) {
                    throw new MyExceptions(getCountOfScannerInput());
                }
                try {
                    d2 = new SimpleDateFormat("dd.MM.yyyy").parse(searchDate2);
                } catch (ParseException e) {
                    throw new MyExceptions(getCountOfScannerInput());
                }
                if (d1.after(d2) || d1.equals(d2))
                    throw new MyExceptions(getCountOfScannerInput());
                break;
            } catch (MyExceptions e) {
                e.getRussianMessage();
            }
        }

        ArrayList<Weather> weathers = Root.getInstance().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();
        for (Weather weather : weathers) {
            if (convertStringToDate2(searchDate1).before(convertStringToDate(weather.getDate())) &&
                    convertStringToDate2(searchDate2).after(convertStringToDate(weather.getDate()))) {
                weather.getDate();
                weathers2.add(weather);
            }
        }
        return "Root (name=" + Root.getInstance().getName() + ", date=" +
                convertDate(Root.getInstance().getDate())+ ",weather=" + weathers2 + ")";
    }



    // метод для поиска погоды по городу
    public static String setCityForSearchWeather() {
        System.out.println(sbMethod(6));

        ArrayList<Weather> weathers2 = new ArrayList<>();
        ArrayList<Weather> weathers = Root.getInstance().getWeather();
        // вводим город и проверяем его наличие
        while (true) {
            Scanner in = new Scanner(System.in);
            String searchCity = in.next();

            for (Weather weather : weathers) {
                ArrayList<String> location = weather.getLocation();
                System.out.println("!!!   "+location.get(0));
                for (int aLocation=0;aLocation<location.size();aLocation++) {
                    if (location.get(aLocation).startsWith(searchCity))
                        weathers2.add(weather);
                }
            }
            // если ничего не нашли
            if (weathers2.isEmpty())
                System.out.println("Данный город отсутствует в списке. Проверьте корректность ввода.");
            else break;
        }

        return "Root (name=" + Root.getInstance().getName() + ", date=" +
                convertDate(Root.getInstance().getDate())+ ", weather=" + weathers2 + ")";

    }





}
