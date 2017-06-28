package Weather.Parse;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// НЕ РАБОТАЕТ SERIALAZED   !!!

public class JSONParse implements Parse{

    // переопределяем метод getPath() для JSONParse
    @Override
    public String getPath() {
        return LINK_JSON;
    }

    // переопределяем метод parseThis() для JSONParse
    @Override
    public Root parseThis() {

        // создаем объект класса JSONParser
        JSONParser parser = new JSONParser();
        // создаем объект класса Root
        Root root = Root.getInstance();

        try {
            // создаем объект распарсенного файла для его последующего разбора
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(LINK_ON_THIS_SYSTEM));

            // считываем name в root
            String name = (String)rootObj.get("name");
            root.setName(name);
            // считываем date в root
            String dateRoot = (String)rootObj.get("date");
            root.setDate(dateRoot);

            // создаем лист для элементов массива weather
            ArrayList<Weather> weatherList = new ArrayList<>();
            // считываем массив weather в новую переменную для последующего разбора
            JSONArray weatherArray = (JSONArray)rootObj.get("weather");

            // пока массив не окончен
            for(Object item:weatherArray){
                // берем один элемент
                JSONObject itemObj = (JSONObject)item;
                // создаем наш элемент weather
                Weather weather = new Weather();

                // считываем все поля очередного элемента массива weather
                long id = (long)itemObj.get("id");
                String title = (String) itemObj.get("title");
                String description = (String) itemObj.get("description");
                long tempMin = (long)itemObj.get("temp_min");// НЕ РАБОТАЕТ SERIALAZED   !!!
                long tempMax = (long)itemObj.get("temp_max");// НЕ РАБОТАЕТ SERIALAZED   !!!
                long humidity = (long)itemObj.get("humidity");
                String date = (String) itemObj.get("date");
                ArrayList<String> location = (ArrayList<String>) itemObj.get("location");

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
            System.out.println("Ошбика чтения .json файла "+e.toString());
        }

        return root;
    }

}
