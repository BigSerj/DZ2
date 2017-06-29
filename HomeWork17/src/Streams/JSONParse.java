package Streams;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;


public class JSONParse implements Parse {

    // переопределяем метод parseThis() для JSONParse
    @Override
    public Root parseThis() {

        // создаем объект класса JSONParser
        JSONParser parser = new JSONParser();
        // создаем объект класса Root
        Root root = Root.getInstance();

        try {
            // создаем объект распарсенного файла для его последующего разбора
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(Constants.LINK_ON_THIS_SYSTEM));

            // считываем name в root
            String name = (String)rootObj.get(Constants.NAME_TAG);
            root.setName(name);
            // считываем date в root
            String dateRoot = (String)rootObj.get(Constants.DATE_TAG);
            root.setDate(dateRoot);

            // создаем лист для элементов массива weather
            ArrayList<Weather> weatherList = new ArrayList<>();
            // считываем массив weather в новую переменную для последующего разбора
            JSONArray weatherArray = (JSONArray)rootObj.get(Constants.WEATHER_TAG);

            // пока массив не окончен
            for (int j=0;j<weatherArray.size();j++){
                // берем один элемент
                JSONObject itemObj = (JSONObject)weatherArray.get(j);
                // создаем наш элемент weather
                Weather weather = new Weather();


                // считываем все поля очередного элемента массива weather
                long id = -999;
                try {
                    try {
                        id = (long) itemObj.get(Constants.ID_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.ID_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String title = "";
                try {
                    try {
                        title = (String) itemObj.get(Constants.TITLE_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.TITLE_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String description = "";
                try {
                    try {
                        description = (String) itemObj.get(Constants.DESCRIPTION_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.DESCRIPTION_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long tempMin = -999;
                try {
                    try {
                        tempMin = (long) itemObj.get(Constants.TEMP_MIN_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.TEMP_MIN_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long tempMax = -999;
                try {
                    try {
                        tempMax = (long) itemObj.get(Constants.TEMP_MAX_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.TEMP_MAX_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long humidity = -999;
                try {
                    try {
                        humidity = (long) itemObj.get(Constants.HUMIDITY_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.HUMIDITY_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String date = "";
                try {
                    try {
                        date = (String) itemObj.get(Constants.DATE_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.DATE_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                ArrayList<String> location = new ArrayList<>();
                try {
                    try {
                        location = (ArrayList<String>) itemObj.get(Constants.LOCATION_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(Constants.LOCATION_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                // вписываем считанное, соответственно, в наш объект weather
                weather.setId((int)id);
                weather.setTitle((String) title);
                weather.setDescription((String)description);
                weather.setTempMin((int)tempMin);
                weather.setTempMax((int) tempMax);
                weather.setHumidity((int) humidity);
                weather.setDate((String) date);
                weather.setLocation(location);

                // заносим наш очередной объект weather в корзину weather`ов
                weatherList.add(weather);
            }

            // вносим всю корзину weather`ов в root
            root.setWeather(weatherList);

        // при обнаружении ошибки считываания файла вылезет соотв. сообщение об ошибке:
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла. Проверьте скрипт на наличие несоответствующих " +
                    "элементов. "+e.toString());
        }

        return root;
    }

}
