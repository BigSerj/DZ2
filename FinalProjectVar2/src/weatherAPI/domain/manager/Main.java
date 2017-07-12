package weatherAPI.domain.manager;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.net.HTTPUrlConnector;
import weatherAPI.data.parse.parsers.Parse;
import weatherAPI.domain.tasks.task1.SetDateForSearch;
import weatherAPI.domain.tasks.task2.SetDatePeriodForSearch;
import weatherAPI.domain.tasks.task4.SetCityForSearchWeather;
import weatherAPI.domain.tasks.task5.SortingByTempAndHumidity;
import weatherAPI.domain.tasks.task6.SearchCityByRangeOfTemp;
import weatherAPI.domain.tasks.task7.SearchMiddleMaxTempInRegion;
import weatherAPI.presentation.menu.*;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.Constants.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class Main {

    // счетчик времени считывания
    private volatile static int seconds;
    // переменная слежения за появлением ошибки при выполнении
    private volatile static boolean exc = true;


    public static void main(String[] args) {


        // Выводим приветственное сообщение
        System.out.println(MAIN_MENU_HELLO);

        // создаем объект-singleton для управления сообщениями
        ControlCentreMenu.getInstance();

        // создаем объект-singleton для управления работой с данными
        DataManager dataManager = DataManager.getInstance();

        // вечный цикл
        while (true) {

            // выводим первое сообщение из списка меню
            System.out.println(showCurrentMenu(MAIN_MENU_SWITCH_PARSING));

            // Создаем объект для парсинга. Выбираем вид парсинга, вводим значения с клавиатуры, ловим exceptions
            // устанавливаем новый вид парсинга файла
            dataManager.setParser();
            // присваиваем локальной переменной этот вид парсинга
            Parse parseObj = dataManager.getParser();



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



            // парсим файл
            parseObj.parsing();



            // вызываем метод с меню выбора задания

            // Создаем объект View
            ShowResult view = new ShowResult();
            // Создаем объект Меню
            MenuTask model = new MenuTask();
            // Создаем объект контроллер
            ShowResultController controller = new ShowResultController(view,model);

            // выводим на экран сообщение о выборе меню
            controller.updateViewMain();
            controller.setModelMenuInputNumber();
            switch (controller.getModelMenuInputNumber()) {
                case 1:
                    controller.updateView1(new SetDateForSearch().setSomeScannerTask1Task5());
                    break;
                case 2:
                    controller.updateView1(new SetDatePeriodForSearch().setSomeScannerTask1Task5());
                    break;
                case 3:
                    controller.updateView1(dataManager.getRoot().getWeather());
                    break;
                case 4:
                    controller.updateView1(new SetCityForSearchWeather().setSomeScannerTask1Task5());
                    break;
                case 5:
                    controller.updateView1(new SortingByTempAndHumidity().setSomeScannerTask1Task5());
                    break;
                case 6:
                    controller.updateView2(new SearchCityByRangeOfTemp().searchCityByRangeOfTemp());
                    break;
                case 7:
                    controller.updateView3(new SearchMiddleMaxTempInRegion().searchMiddleMaxTempInRegion());
            }

        }
    }
}