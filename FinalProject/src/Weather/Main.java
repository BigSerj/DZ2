package Weather;

import Weather.Parse.SwitchParsing;
import Weather.Parse.Parse;


public class Main{

    // счетчик времени считывания
    static int seconds = 0;

    public static void main(String[] args){

        // Выводим вводное сообщение
        System.out.println(LoopedMessages.sbMethod(1)
                .append(LoopedMessages.sbMethod(2)).toString());

        // Выбираем вид парсинга, вводим значения с клавиатуры, ловим Exceptions
        final Parse parseObj = SwitchParsing.switchParsingMethod();

        // Создаем отдельный поток для скачивания файла
        final Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                // Открываем соединение с сервером, скачиваем файл на устройство (компьютер/телефон/планшет и т.д.)
                HTTPUrlConnectorClass.inputStreamClass(parseObj.getPath());
                System.out.println("\nЗагрузка файла заняла: "+seconds+"сек.\n");
            }
        });
        // переименовываем поток
        thread1.setName("DownloadFileThread");
        // запускаем поток
//        thread1.start();


            // ожидаем завершения скачивания файла
        System.out.println("Ожидайте окончания скачивания файла на Ваше устройство...");
            // выполняем, пока поток не окончен
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    System.out.println("Время ожидания: " + seconds + " сек.");
                    try {
                        seconds = 5;
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Ошибка ожидания завершения потока " + thread1.getName() +
                                ", отвечающего за установление соединения с сервером и искачивание файла " + e.toString());
                    }
                } while (thread1.isAlive());
            }
        });

        thread1.start();
        thread2.start();


        // парсим и выводим на экран результат
        System.out.println(parseObj.parseThis());


    }


}