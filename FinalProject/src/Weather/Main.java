package Weather;

import java.util.Scanner;

import static Weather.Parse.GSONParse.parseGson;
import static Weather.Parse.JSONParse.parseJSON;
import static Weather.Parse.ParseXML.parseXML;

public class Main {

    public static void main(String[] args) {

//        String jsonFileWeather = "http://kiparo.ru/t/weather.json";      // НЕКОРРЕКТНЫЙ ФАЙЛ !!!    В строке 23 нужно добавить "temp_max":   (второй массив данных weather-а)
        String jsonFileWeather = "weather.json";
        String xmlFileWeather = "http://kiparo.ru/t/weather.xml";

        Scanner in = new Scanner(System.in);
        System.out.println("Введите\n1-для парсинга файла .json стандартной библиотекой\n2-для парсинга файла .json библиотекой GSON\n3-для парсинга файла .xml");

        try {
            Integer in2 = in.nextInt();
            switch (in2) {
                case 1:
                    System.out.println(parseJSON(jsonFileWeather));
                    break;
                case 2:
                    System.out.println(parseGson(jsonFileWeather));
                    break;
                case 3:
                    System.out.println(parseXML(xmlFileWeather));
                    break;
            }
        } catch (Exception e) {
            System.out.println("Введите 1,2 или 3");
        }
    }

}