package Weather.ParseAndHTTPConnection;


public interface Parse {

    // метод для возврата соответствующей ссылки для парсинга
    String getPath();
    // метод парсинга
    void parsing();

}
// Factory Method
// Observer