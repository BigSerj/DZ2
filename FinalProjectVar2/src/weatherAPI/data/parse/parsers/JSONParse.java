package weatherAPI.data.parse.parsers;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Root;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.exceptions.MyExceptions;

import java.io.FileReader;
import java.util.ArrayList;

import static weatherAPI.data.constants.LinksConst.*;
import static weatherAPI.data.constants.TagsConst.*;


public class JSONParse implements Parse {


    // переопределяем метод getPath() для JSONParse
    @Override
    public String getPath() {
        return LINK_JSON;
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
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(LINK_ON_THIS_SYSTEM));

            // считываем name в parsed
            String name = (String)rootObj.get(NAME_TAG);
            root.setName(name);
            // считываем date в parsed
            String dateRoot = (String)rootObj.get(DATE_TAG);
            root.setDate(dateRoot);

            // создаем лист для элементов массива weather
            ArrayList<Weather> weatherList = new ArrayList<>();
            // считываем массив weather в новую переменную для последующего разбора
            JSONArray weatherArray = (JSONArray)rootObj.get(WEATHER_TAG);

            // пока массив не окончен
            for (int j=0;j<weatherArray.size();j++){
                // берем один элемент
                final JSONObject itemObj = (JSONObject)weatherArray.get(j);
                // создаем наш элемент weather
                Weather weather = new Weather();



                // Создаем вложенный класс для проверки водимых значений
                class Check{
                    private long parseLong(int j, String tag){
                        try {
                            try {
                                return (long) itemObj.get(tag);
                            } catch (Exception e) {
                                throw new MyExceptions(tag, e);
                            }
                        }catch (MyExceptions e){
                            e.getRussianMessage(j);
                        }
                        return -999;
                    }
                    private String parseString(int j, String tag){
                        try {
                            try {
                                return (String) itemObj.get(tag);
                            } catch (Exception e) {
                                throw new MyExceptions(tag, e);
                            }
                        }catch (MyExceptions e){
                            e.getRussianMessage(j);
                        }
                        return "";
                    }
                }

                // считываем все поля очередного элемента массива weather
                Check check = new Check();
                long id = check.parseLong(j,ID_TAG);
                String title = check.parseString(j,TITLE_TAG);
                String description = check.parseString(j,DESCRIPTION_TAG);
                long tempMin = check.parseLong(j,TEMP_MIN_TAG);
                long tempMax = check.parseLong(j,TEMP_MAX_TAG);
                long humidity = check.parseLong(j,HUMIDITY_TAG);
                String date = check.parseString(j,DATE_TAG);

                // для одного location не имеет смысла создавать метод, поэтому, делаем на месте
                ArrayList<String> location = new ArrayList<>();
                try {
                    try {
                        location = (ArrayList<String>) itemObj.get(LOCATION_TAG);
                    } catch (Exception e) {
                        throw new MyExceptions(LOCATION_TAG,e);
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
