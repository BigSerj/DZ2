package weatherAPI.data.parse.parsers;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import weatherAPI.data.constants.LinksConst;
import weatherAPI.data.constants.TagsConst;
import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Root;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.exceptions.MyExceptions;

import java.io.FileReader;
import java.util.ArrayList;


public class JSONParse implements Parse {


    // переопределяем метод getPath() для JSONParse
    @Override
    public String getPath() {
        return LinksConst.LINK_JSON;
    }

    // переопределяем метод parsing() для JSONParse
    @Override
    public void parsing() {

        // создаем объект класса JSONParser
        JSONParser parser = new JSONParser();
        // создаем объект класса parsed
        Root root = DataManager.getInstance().getRoot();

        try {
            // создаем объект распарсенного файла для его последующего разбора
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(LinksConst.LINK_ON_THIS_SYSTEM));
//            JSONObject rootObj = (JSONObject)parser.parse(new FileReader("weather.json"));

            // считываем name в parsed
            String name = (String)rootObj.get(TagsConst.NAME_TAG);
            root.setName(name);
            // считываем date в parsed
            String dateRoot = (String)rootObj.get(TagsConst.DATE_TAG);
            root.setDate(dateRoot);

            // создаем лист для элементов массива weather
            ArrayList<Weather> weatherList = new ArrayList<>();
            // считываем массив weather в новую переменную для последующего разбора
            JSONArray weatherArray = (JSONArray)rootObj.get(TagsConst.WEATHER_TAG);

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
                        id = (long) itemObj.get(TagsConst.ID_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.ID_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String title = "";
                try {
                    try {
                        title = (String) itemObj.get(TagsConst.TITLE_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.TITLE_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String description = "";
                try {
                    try {
                        description = (String) itemObj.get(TagsConst.DESCRIPTION_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.DESCRIPTION_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long tempMin = -999;
                try {
                    try {
                        tempMin = (long) itemObj.get(TagsConst.TEMP_MIN_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.TEMP_MIN_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long tempMax = -999;
                try {
                    try {
                        tempMax = (long) itemObj.get(TagsConst.TEMP_MAX_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.TEMP_MAX_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                long humidity = -999;
                try {
                    try {
                        humidity = (long) itemObj.get(TagsConst.HUMIDITY_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.HUMIDITY_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                String date = "";
                try {
                    try {
                        date = (String) itemObj.get(TagsConst.DATE_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.DATE_TAG,e);
                    }
                }catch (MyExceptions e){
                    e.getRussianMessage(j);
                }

                ArrayList<String> location = new ArrayList<>();
                try {
                    try {
                        location = (ArrayList<String>) itemObj.get(TagsConst.LOCATION_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(TagsConst.LOCATION_TAG,e);
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

            // вносим всю корзину weather`ов в parsed
            root.setWeather(weatherList);

        // при обнаружении ошибки считываания файла вылезет соотв. сообщение об ошибке:
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла. Проверьте скрипт на наличие несоответствующих " +
                    "элементов. "+e.toString());
        }
    }

}
