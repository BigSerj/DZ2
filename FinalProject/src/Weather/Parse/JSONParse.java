package Weather.Parse;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// НЕ РАБОТАЕТ SERIALAZED   !!!

public class JSONParse {

//    public static void main(String[] args) {
//        Root root = parseJSON("weather.json");
//        System.out.println(root.toString());
//    }


    public static Root parseJSON(String path){

        JSONParser parser = new JSONParser();
        Root root = Root.getInstance();

        try {
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(path));

            String name = (String)rootObj.get("name");
            root.setName(name);
            String dateRoot = (String)rootObj.get("date");
            root.setDate(dateRoot);

            ArrayList<Weather> weatherList = new ArrayList<>();
            JSONArray weatherArray = (JSONArray)rootObj.get("weather");

            for(Object item:weatherArray){
                JSONObject itemObj = (JSONObject)item;
                Weather weather = new Weather();

                long id = (long)itemObj.get("id");
                String title = (String) itemObj.get("title");
                String description = (String) itemObj.get("description");
                long tempMin = (long)itemObj.get("temp_min");// НЕ РАБОТАЕТ SERIALAZED   !!!
                long tempMax = (long)itemObj.get("temp_max");// НЕ РАБОТАЕТ SERIALAZED   !!!
                long humidity = (long)itemObj.get("humidity");
                String date = (String) itemObj.get("date");
                ArrayList<String> location = (ArrayList<String>) itemObj.get("location");

                weather.setId((int)id);
                weather.setTitle((String) title);
                weather.setDescription((String)description);
                weather.setTempMin((int)tempMin);
                weather.setTempMax((int) tempMax);
                weather.setHumidity((int) humidity);
                weather.setDate((String) date);
                weather.setLocation(location);
                weatherList.add(weather);
            }

            root.setWeather(weatherList);


        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла "+e.toString());
        }
        return root;
    }

}
