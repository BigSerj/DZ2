package Weather.Parse;

public interface Parse {

    // метод для возврата соответствующей ссылки для парсинга
    String getPath();
    // метод парсинга
    Root parseThis();

}
// Factory Method
// Observer