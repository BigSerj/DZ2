package Weather;

import Weather.Parse.SwitchParsing;
import Weather.Parse.Parse;


public class Main{

    public static void main(String[] args){

        // Выводим вводное сообщение
        System.out.println(LoopedMessages.sbMethod(1).append(LoopedMessages.sbMethod(2)).toString());

        // Выбираем вид парсинга, вводим значения с клавиатуры, ловим Exceptions
        Parse parseObj = SwitchParsing.switchParsingMethod();


        // Создаем отдельный поток для скачивания файла
        final Parse finalParseObj = parseObj;
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                // Открываем соединение с сервером, скачиваем файл на устройство (компьютер/телефон/планшет и т.д.)
                HTTPUrlConnectorClass.inputStreamClass(finalParseObj.getPath());
            }
        });
        // переименовываем поток
        thread1.setName("DownloadFileThread");
        // запускаем поток
        thread1.start();

        // ожидаем завершения скачивания файла
        System.out.println("Ожидайте окончания скачивания файла на Ваше устройство...");
        int seconds = 0;
        // выполняем, пока поток не окончен
        do {
            System.out.println("Время ожидания: "+seconds+" сек.");
            try {
                thread1.join(1000);
                seconds++;
            } catch (InterruptedException e) {
                System.out.println("Ошибка ожидания завершения потока "+thread1.getName()+
                        ", отвечающего за установление соединения с сервером и искачивание файла "+e.toString());
            }
        }while(thread1.isAlive());




        // Выводим на экран поля объекта класса Root
        System.out.println(parseObj.parseThis());



    }

}