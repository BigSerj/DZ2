package weatherAPI.domain.tasks.task7;


import weatherAPI.data.constants.TagsConst;
import weatherAPI.data.manager.DataManager;
import weatherAPI.data.parse.parsed.Weather;

import java.util.ArrayList;


public class SortingCore {

    private static String constTagThis;

    public static ArrayList<Weather> sortingMethod(String constTag, boolean isSortUp){

        constTagThis =constTag;

        ArrayList<Weather> weathers = DataManager.getInstance().getRoot().getWeather();
        ArrayList<Weather> weathers2 = new ArrayList<>();

        for (int i=0;i<weathers.size();i++) {
            // сортировка по возрастанию(isSortUp)||убыванию(!isSortUp)
            if (weathers2.size() == 0) // если проходимся первый раз
                weathers2.add(weathers.get(i));
            // если параметр сразу больше(меньше) самой большей(меньшей) - то добавляем в конец
            else if ((caseTag(weathers,i) > caseTag(weathers2,weathers2.size() - 1) && isSortUp) ||
                        (caseTag(weathers, i) < caseTag(weathers2,weathers2.size() - 1) && !isSortUp))
                weathers2.add(weathers.get(i));
            // если в коллекции более 1 элемента
            else if (weathers2.size()>1){
                int weatherSize = weathers2.size();
                for (int j = 0; j < weatherSize-1; j++) {
                    if (isSortUp) {// сортировка по возрастанию
                        // если нашли тот элемент, который меньше текущего и не больше следующего
                        if (caseTag(weathers, i) > caseTag(weathers2, j) &&
                                caseTag(weathers, i) <= caseTag(weathers2, j + 1)) {
                            // сдвигаем вправо на 1 элемент от на 1 шаг правее от найденного до предпоследнего
                            addToArrayWeather(weathers2, weathers.get(i), weatherSize, j + 1);
                            break;
                        // иначе, если посл итерация и не подошло условие - просто записываем в начало
                        }else if (j==weatherSize-2) {
                            addToArrayWeather(weathers2, weathers.get(i), weatherSize, 0);
                            break;
                        }
                    }else{// сортировка по убыванию
                        // если нашли тот элемент, который больше текущего и не меньше следующего
                        if (caseTag(weathers, i)<caseTag(weathers2, j) &&
                                caseTag(weathers ,i)>=caseTag(weathers2, j+1)){
                            addToArrayWeather(weathers2, weathers.get(i), weatherSize, j + 1);
                            break;
                        // иначе, если посл итерация и не подошло условие - просто записываем в начало
                        }else if (j==weatherSize-2) {
                            addToArrayWeather(weathers2, weathers.get(i), weatherSize, 0);
                            break;
                        }
                    }
                }
            }
            // если в коллекции 1 элемент и он уже больше(меньше), чем проверяемый -
            // сдвигаем последний вправо и добавляем на 1 место проверяемый
            else {
                weathers2.add(weathers2.get(0));
                weathers2.set(0, weathers.get(i));
            }
        }
        return weathers2;
    }



    // метода для выбора и возврата того тэга,который необходим прямо сейчас.
    private static Integer caseTag(ArrayList<Weather> weatherThis, int i){
        switch (constTagThis){
            case TagsConst.TEMP_MAX_TAG:return weatherThis.get(i).getTempMax();
            case TagsConst.TEMP_MIN_TAG:return weatherThis.get(i).getTempMin();
            case TagsConst.HUMIDITY_TAG:return weatherThis.get(i).getHumidity();
        }
        return -1;
    }

    // метод свдига элементов коллекции на указанное кол-во раз вправо
    private static void addToArrayWeather(ArrayList<Weather> weathers2, Weather weather, int weatherSize, int a){
        // дублируем (сдвигаем) последний элемент
        weathers2.add(weathers2.get(weatherSize - 1));
        for (int k = weatherSize; k > a; k--)
            weathers2.set(k, weathers2.get(k - 1));
        weathers2.set(a, weather);
    }


}
