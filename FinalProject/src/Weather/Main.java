package Weather;

import Weather.ExceptionsMessages.LoopedMessages;
import Weather.ParseAndHTTPConnection.*;
import static Weather.ScannerInputProcessing.*;


public class Main {

    // счетчик времени считывания
    private volatile static int seconds = 0;
    private volatile static boolean exc = true;

    public static void main(String[] args) {

        // Выводим вводное сообщение
        System.out.println("========================================================================================================================");
        System.out.println(LoopedMessages.sbMethod(1));
        while (true){
            System.out.println(LoopedMessages.sbMethod(2));

            // Создаем объект для парсинга. Выбираем вид парсинга, вводим значения с клавиатуры, ловим Exceptions
            Parse parseObj = switchParse();

            // Создаем отдельный поток для скачивания файла
            final Parse finalParseObj = parseObj;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Открываем соединение с сервером, скачиваем файл на устройство (компьютер/телефон/планшет и т.д.)
                if (!HTTPUrlConnectorClass.inputStreamClass(finalParseObj.getPath()))
                    exc = false;
                else
                    System.out.println("Загрузка файла заняла: " + seconds + " сек.\n");

                }
            });
            // переименовываем поток
            thread1.setName("DownloadFileThread");
            // запускаем поток
            
            //thread1.start();


            // ожидаем завершения скачивания файла
            System.out.println("\nОжидайте окончания скачивания файла на Ваше устройство...");
            // выполняем, пока поток не окончен
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
            System.out.println("========================================================================================================================");
            // Выбираем, что вывести на экран (дату/период/все)
            System.out.println(LoopedMessages.sbMethod(3));
            System.out.println(switchWeatherView());
            System.out.println("========================================================================================================================\n");




        }
    }










    // В зависимости от выбранного вида парсинга создаем соотв. объект и возвращаем его в Main
    private static Parse switchParse() {
        switch (switch123()) {
            case 1:
                return new JSONParse();
            case 2:
                return new GSONParse();
            case 3:
                return new ParseXML();
        }
        return null;
    }


    // метод для выбора отображения на экране
    private static String switchWeatherView() {
        switch (switch123()) {
            case 1:
                return setDateForSearch();
            case 2:
                return setDatePeriodForSearch();
            case 3:
                return Root.getInstance().toString();
            case 4:
                return setCityForSearchWeather();
        }
        return null;
    }




}