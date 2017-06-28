package Weather.Parse;

public interface Parse {

    // объявляем константы
    String LINK_JSON = "weather.json";
    String LINK_XML = "http://kiparo.ru/t/weather.xml";
    String LINK_ON_THIS_SYSTEM = "/Flash/JAVA for ANDROID/ex2.txt";

    // метод для возврата соответствующей ссылки для парсинга
    String getPath();
    // метод парсинга
    Root parseThis();

}
