package Weather.ParseAndHTTPConnection;

import Weather.Root;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import Weather.Constants;


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
            root.setWeather(root1.getWeather());
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла " + e.toString());
        }
    }
}
