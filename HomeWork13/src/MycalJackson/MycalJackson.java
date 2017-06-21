package MycalJackson;


import com.fasterxml.jackson.core.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class MycalJackson {

    public static void main(String[] args) throws IOException{
        Root root = new Root();
        readJson(root);
        System.out.println(root.toString());
    }

    private static void readJson(Root root) throws IOException {

        ArrayList<Weather> weatherList = new ArrayList<>();
        int uu=1;

        JsonFactory jsonFactory = new JsonFactory();

        JsonParser jsonParser = jsonFactory.createParser(new FileReader("test.json"));
        jsonParser.nextToken();
        while(jsonParser.nextToken() != JsonToken.END_OBJECT) {
            if (root.getName()==null) {
                jsonParser.nextToken();
                root.setName(jsonParser.getText());
            }else if (root.getDate()==null) {
                jsonParser.nextToken();
                root.setDate(jsonParser.getText());
            }else if ("weather".equals(jsonParser.getCurrentName())) {
                jsonParser.nextToken();
            }else{
                Weather weather = new Weather();
                while(jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    if ("id".equals(jsonParser.getCurrentName())) {
                        weather = new Weather();
                        jsonParser.nextToken();
                        weather.setId(jsonParser.getIntValue());
                    } else if ("title".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setTitle(jsonParser.getText());
                    } else if ("description".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setDescription(jsonParser.getText());
                    } else if ("temp_min".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setTemp_min(jsonParser.getIntValue());
                    } else if ("temp_max".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setTemp_max(jsonParser.getIntValue());
                    } else if ("humidity".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setHumidity(jsonParser.getIntValue());
                    } else if ("date".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        weather.setDate(jsonParser.getText());
                    } else if ("location".equals(jsonParser.getCurrentName())) {
                        jsonParser.nextToken();
                        ArrayList<String> location = new ArrayList<>();
                        while (jsonParser.nextToken() != JsonToken.END_ARRAY)
                            location.add(jsonParser.getText());
                        weather.setLocation(location);
                        weatherList.add(weather);
                    }
                }
            }
        }
        root.setWeatherList(weatherList);
    }
}
