package weatherAPI.data.parse.parsers;


public interface Parse {

    // метод для возврата соответствующей ссылки для парсинга
    String getPath();
    // метод парсинга
    void parsing();

}