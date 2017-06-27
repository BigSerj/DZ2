package Task2Observer;

public class MainTask2 {

    public static void main(String[] args) {

        // Создание наблюдателя и субъекта
        NewsAgence newsAgency = new NewsAgence();
        RadioChannel radioChannel = new RadioChannel();

        // Регистрация наблюдателя на субъекте
        newsAgency.register(radioChannel);

        // Добавление новостных заголовков
        newsAgency.addNews("Танк врезался в дерево на проспекте Независимости.");
        newsAgency.addNews("ШОК! Коты начали гавкать!");
        newsAgency.addNews("Гей-парад в Москве запланирован на 2 августа. ВДВ улыбается и разминается.");
    }

}