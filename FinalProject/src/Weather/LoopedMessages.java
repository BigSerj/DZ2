package Weather;

public class LoopedMessages {

    // метод для сообщений, которые используются повторно, могут быть составными частями большего сообщения
    public static StringBuffer sbMethod(int switchMethod){
        StringBuffer sb = new StringBuffer();
        switch (switchMethod){
            case 1:return sb.append("Здравствуйте!\n");
            case 2:return sb.append("Введите:\n1-для парсинга файла .json стандартной библиотекой\n" +
                    "2-для парсинга файла .json библиотекой GSON\n3-для парсинга файла .xml");
        }
        return sb;
    }

}
