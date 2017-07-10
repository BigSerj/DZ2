package Weather;


import Weather.ExceptionsMessages.MessagesControlCentre;
import Weather.ParseAndHTTPConnection.*;
import java.util.ArrayList;
import static Weather.DateMethods.convertDate;
import static Weather.ScannerInputMethods.SearchCityByRangeOfTemp.searchCityByRangeOfTemp;
import static Weather.ScannerInputMethods.SearchMiddleMaxTempInRegion.searchMiddleMaxTempInRegion;
import static Weather.ScannerInputMethods.SetCityForSearchWeather.setCityForSearchWeather;
import static Weather.ScannerInputMethods.SetDateForSearch.setDateForSearch;
import static Weather.ScannerInputMethods.SetDatePeriodForSearch.setDatePeriodForSearch;
import static Weather.ScannerInputMethods.SortingByTempAndHumidity.sortingByTempAndHumidity;
import static Weather.ScannerInputMethods.ScannerInTryCatchMethods.scannerToString;


public class Main {

    // счетчик времени считывания
    private volatile static int seconds;
    private volatile static boolean exc = true;

    public static void main(String[] args) {

        // Выводим вводное сообщение
        System.out.println(MessagesControlCentre.sbMethod(EnumMessage.MAIN_MENU_HELLO));
        while (true) {
            System.out.println(MessagesControlCentre.sbMethod(EnumMessage.MAIN_MENU_SWITCH_PARSING));

            // Создаем объект для парсинга. Выбираем вид парсинга, вводим значения с клавиатуры, ловим Exceptions
            Parse parseObj = null;
            switch (scannerToString()) {
                case 1:
                    parseObj = new JSONParse();break;
                case 2:
                    parseObj = new GSONParse();break;
                case 3:
                    parseObj = new ParseXML();
            }

            // Создаем отдельный поток для скачивания файла
            final Parse finalParseObj = parseObj;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Открываем соединение с сервером, скачиваем файл на устройство (компьютер/телефон/планшет и т.д.)
                    if (!HTTPUrlConnectorClass.inputStreamClass(finalParseObj.getPath()))
                        exc = false;
                    else System.out.println("Загрузка файла заняла: " + seconds + " сек.\n");

                }
            });
            // переименовываем поток
            thread1.setName("DownloadFileThread");
            // запускаем поток
            // комментим - если надо оффлайн, и в ParseXML далаем вместо url - dom = db.parse("weather.xml");
//            thread1.start();
            thread1.start();


            // ожидаем завершения скачивания файла
            System.out.println("\nОжидайте окончания скачивания файла на Ваше устройство...");
            // выполняем, пока поток не окончен
            seconds = 0;
            do {
                System.out.println("Время ожидания: " + seconds + " сек.");
                try {
                    thread1.join(1000);
                    seconds++;
                } catch (InterruptedException e) {
                    System.out.println("Ошибка ожидания завершения потока " + thread1.getName() +
                            ", отвечающего за установление соединения с сервером и искачивание файла " + e.toString());
                }
            } while (thread1.isAlive());


            // проверка на наличие ошибо
            // тут надо реализовать Observer !!!!  паттерн для слежением появления ошибки при открытии,
            // скачивании, парсинге файлов.
            // Если ошибка где-то появилась - сообщаем об этом слушателю, а он уже изменяет exc если ошибка появилась.
            if (!exc)
                break;


            // парсим
            parseObj.parsing();

            // Выбираем, что вывести на экран (дату/период/все)
            System.out.println(MessagesControlCentre.sbMethod(EnumMessage.MAIN_MENU_SWITCH_TASK));
            switch (scannerToString()) {
                case 1:
                    toScreen(setDateForSearch());
                    break;
                case 2:
                    toScreen(setDatePeriodForSearch());
                    break;
                case 3:
                    toScreen(Root.getInstance().getWeather());
                    break;
                case 4:
                    toScreen(setCityForSearchWeather());
                    break;
                case 5:
                    toScreen(sortingByTempAndHumidity());
                    break;
                case 6:
                    toScreen2(searchCityByRangeOfTemp());
                    break;
                case 7:
                    toScreen3(searchMiddleMaxTempInRegion());
            }



        }
    }

    // метод для вывода на экран
    private static void toScreen(ArrayList<Weather> newWeather){
        System.out.println("Root (name=" + Root.getInstance().getName() + ", date=" +
                convertDate(Root.getInstance().getDate()) + ", weather=" + newWeather + ")");
    }
    private static void toScreen2(ArrayList<String> locationFind){
        System.out.println(locationFind);
    }
    private static void toScreen3(Integer[] locationFind){
        System.out.println("Средняя температура по ргеиону = " + locationFind[0]);
        System.out.println("Максимальная температура по ргеиону = " + locationFind[1]);
    }



}

// если иключение в catch - это блок catch игнорируется и выполняется finally.
// Если и в finally исключение - тогда ошибка.