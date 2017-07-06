package Weather.ExceptionsMessages;

public class LoopedMessages {

    public static int getCountOfScannerInput() {
        return countOfScannerInput;
    }

    private static int countOfScannerInput;

    // метод для сообщений, которые используются повторно, могут быть составными частями большего сообщения
    public static StringBuffer sbMethod(int switchMethod){
        StringBuffer sb = new StringBuffer();
        countOfScannerInput = switchMethod;
        switch (switchMethod){
            case 1:return sb.append("Здравствуйте!\n");
            case 2:return sb.append("Введите:\n1-для парсинга файла .json стандартной библиотекой\n" +
                    "2-для парсинга файла .json библиотекой GSON\n3-для парсинга файла .xml");
            case 3:return sb.append("Введите:\n1-для вывода погоды за определенный день\n" +
                    "2-для вывода погоды за определенный период\n3-для вывода всего на экран" +
                    "\n4-для поиска погоды по определенному городу\n5-для сортировки по температуре" +
                    "\n6-для сортировки по влажности\n7-для поиска городов по дипазону температур" +
                    "\n8-для выода средней, максимальной температуры по региону.");
            case 4:return sb.append("Введите искомую дату в формате: день.месяц.год (пример: 23.02.1988).");
            case 5:return sb.append("Введите искомый период \"с\"-\"по\", где первая дата меньше второй. Формат дат: день.месяц.год" +
                    " \n(Пример: \nПериод с: 23.02.1988\nПериод по: 25.02.1988).\n");
            case 6:return sb.append("Введите город из имеющихся для вывода погоды в данном городе:");
        }
        return sb;
    }

}
