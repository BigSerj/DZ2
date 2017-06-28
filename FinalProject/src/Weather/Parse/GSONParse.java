package Weather.Parse;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class GSONParse implements Parse{

    // переопределяем метод getPath() для GSONParse
    @Override
    public String getPath() {
        return LINK_JSON;
    }

    // переопределяем метод parseThis() для GSONParse
    @Override
    public Root parseThis() {

        // создаем объект root
        Root root = Root.getInstance();
        // пробуем открыть файл и распарсить
        try{
            // создаем объект reader и сразу указываем объект нашего файла
            BufferedReader reader = new BufferedReader(new FileReader(LINK_ON_THIS_SYSTEM));
            // создаем объект GSON
            Gson gson = new Gson();
            // парсим и записываем результат в объект root
            root = gson.fromJson(reader, Root.class);
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла " + e.toString());
        }

        return root;
    }
}
