package weatherAPI.presentation.menu;


import java.util.ArrayList;


// ВСЕ СООБЩЕНИЯ
class MenuMessages {

    // методы для заполнения полей объекта сообщениями.
    static ArrayList<String> forConstructorParse() {
        ArrayList<String> pasre = new ArrayList<>();
        pasre.add("-для парсинга файла .json стандартной библиотекой");
        pasre.add("-для парсинга файла .json библиотекой GSON");
        pasre.add("-для парсинга файла .xml");
        return pasre;
    }
    static ArrayList<String> forConstructorTask() {
        ArrayList<String> task = new ArrayList<>();
        task.add("-для вывода погоды за определенный день");
        task.add("-для вывода погоды за определенный период");
        task.add("-для вывода всего на экран");
        task.add("-для поиска погоды по определенному городу");
        task.add("-для сортировки по температуре и влажности");
        task.add("-для поиска городов по дипазону температур");
        task.add("-для вывода средней, максимальной температуры по региону");
        return task;
    }
    static ArrayList<String> forConstructorTag() {
        ArrayList<String> tag = new ArrayList<>();
        tag.add("-для сортировки по максимальной температуре");
        tag.add("-для сортировки по минимальной температуре");
        tag.add("-для сортировки по влажности");
        return tag;
    }
    static ArrayList<String> forConstructorDirection() {
        ArrayList<String> dierct = new ArrayList<>();
        dierct.add("-для сортировки по возрастанию");
        dierct.add("-для сортировки по убыванию");
        return dierct;
    }
    static ArrayList<String> forFindByDate() {
        ArrayList<String> date = new ArrayList<>();
        date.add("число в формате: день.месяц.год. Пример: 02.03.2015");
        return date;
    }
    static ArrayList<String> forFindByPeriod() {
        ArrayList<String> period = new ArrayList<>();
        period.add("искомый период \"с\"-\"по\", где первая дата меньше второй.\n" +
                "Формат дат: день.месяц.год\\n\" +\nПример: \nПериод с: 23.02.1988\nПериод по: 25.02.1988\n");
        return period;
    }
    static ArrayList<String> forFindByCity() {
        ArrayList<String> city = new ArrayList<>();
        city.add("город из имеющихся для вывода погоды в данном городе:");
        return city;
    }
    static ArrayList<String> forFindCityByRangeOfTemp() {
        ArrayList<String> range = new ArrayList<>();
        range.add("температуру:");
        return range;
    }
    static ArrayList<String> forFindMiddleMaxTempInRegion() {
        ArrayList<String> region = new ArrayList<>();
        region.add("регион:");
        return region;
    }

}
