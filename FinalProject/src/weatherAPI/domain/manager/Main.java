package weatherAPI.domain.manager;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.net.HTTPUrlConnector;
import weatherAPI.data.parse.parsers.GSONParse;
import weatherAPI.data.parse.parsers.JSONParse;
import weatherAPI.data.parse.parsers.Parse;
import weatherAPI.data.parse.parsers.ParseXML;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.menu.ControlCentreMenu;

import java.util.ArrayList;
import static weatherAPI.domain.checks.DatesFormat.convertDate;
import static weatherAPI.domain.tasks.task6.SearchCityByRangeOfTemp.searchCityByRangeOfTemp;
import static weatherAPI.domain.tasks.task7.SearchMiddleMaxTempInRegion.searchMiddleMaxTempInRegion;
import static weatherAPI.domain.tasks.task4.SetCityForSearchWeather.setCityForSearchWeather;
import static weatherAPI.domain.tasks.task1.SetDateForSearch.setDateForSearch;
import static weatherAPI.domain.tasks.task2.SetDatePeriodForSearch.setDatePeriodForSearch;
import static weatherAPI.domain.tasks.task5.SortingByTempAndHumidity.sortingByTempAndHumidity;
import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.Constants.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.*;


public class Main {

    // счетчик времени считывания
    private volatile static int seconds;
    private volatile static boolean exc = true;

    public static void main(String[] args) {


        // Выводим приветственное сообщение
        System.out.println(MAIN_MENU_HELLO);

        // создаем объект-singleton для управления сообщениями
        ControlCentreMenu.getInstance();
        // создаем объект-singleton для управления работой с данными
        DataManager.getInstance();

        // вечный цикл
        while (true) {

            // выводим первое сообщение из списка меню
            System.out.println(showCurrentMenu(MAIN_MENU_SWITCH_PARSING));

            // Создаем объект для парсинга. Выбираем вид парсинга, вводим значения с клавиатуры, ловим exceptions
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
                    if (!HTTPUrlConnector.inputStreamClass(finalParseObj.getPath()))
                        exc = false;
                    else System.out.println("Загрузка файла заняла: " + seconds + " сек.\n");

                }
            });
            // переименовываем поток
            thread1.setName("DownloadFileThread");
            // запускаем поток
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



            // Если ошибка где-то появилась - сообщаем об этом слушателю, а он уже изменяет exc если ошибка появилась.
            if (!exc)
                break;


            // парсим
            parseObj.parsing();

            // Выбираем, что вывести на экран (дату/период/все)
            System.out.println(showCurrentMenu(MAIN_MENU_SWITCH_TASK));
            switch (scannerToString()) {
                case 1:
                    toScreen(setDateForSearch());
                    break;
                case 2:
                    toScreen(setDatePeriodForSearch());
                    break;
                case 3:
                    toScreen(DataManager.getInstance().getRoot().getWeather());
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
        System.out.println("parsed (name=" + DataManager.getInstance().getRoot().getName() + ", date=" +
                convertDate(DataManager.getInstance().getRoot().getDate()) + ", weather=" + newWeather + ")");
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