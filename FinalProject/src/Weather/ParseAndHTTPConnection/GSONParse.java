package Weather.ParseAndHTTPConnection;


import Weather.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;


public class GSONParse implements Parse{

    // переопределяем метод getPath() для GSONParse
    @Override
    public String getPath() {
        return Constants.LINK_JSON;
    }

    // переопределяем метод parsing() для GSONParse
    @Override
    public void parsing() {

        // пробуем открыть файл и распарсить
        try{
            // создаем объект reader и сразу указываем объект нашего файла
            BufferedReader reader = new BufferedReader(new FileReader(Constants.LINK_ON_THIS_SYSTEM));
            // создаем объект GSON
            Gson gson = new Gson();
            // парсим и записываем результат в объект root
            Root root1 = gson.fromJson(reader, Root.class);
            Root root = Root.getInstance();
            root.setName(root1.getName());
            root.setDate(root1.getDate());
            // делаем проверку корректности даты, перезаписывая дату каждого элемента weather
            ArrayList<Weather> weather = root1.getWeather();
            for (Weather aWeather : weather) aWeather.setDate(aWeather.getDate());
            root.setWeather(weather);
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла " + e.toString());
        }
    }
}
