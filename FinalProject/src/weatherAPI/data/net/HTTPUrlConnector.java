package weatherAPI.data.net;


import java.io.*;
import java.net.*;
import static weatherAPI.data.constants.LinksConst.*;


public class HTTPUrlConnector {

    public static boolean inputStreamClass(String X_LINK) {

        InputStream inputStreams = null;    // класс для входного потока
        FileOutputStream outputStream = null;      // класс для выходного потока
        boolean exc = true;

        try {
            // открываем соединение
            URL url = new URL(X_LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            // получаем код ответа (от сайта или сервера)
            // например, отсюда берется код 404 при неудачном открытии сайта
            int responseCod = httpURLConnection.getResponseCode();

            // проверяем успешное ли подключение, т.е. проверка на ошибки
            // убедились, что подключение удачное, сайт вернул, что все Ок.
            if (responseCod == HttpURLConnection.HTTP_OK){
                // создаем входной поток
                inputStreams = httpURLConnection.getInputStream();

                // создаем выходной поток для нашего файла
                outputStream = new FileOutputStream(new File(LINK_ON_THIS_SYSTEM));

                // записываем скачиваемую информацию в файл по 1кБ
                // если вернулась -1 - значит файл закончился, все скачали. Количество байт за одно чтение read()
                int bytesRead;
                // скачиваем по 1кБ - выбираем с учетом возможности СИСТЕМЫ (телефон или другое устройство).
                // То, что мы скачиваем, т.е. полезная информация.
                byte[] buffer = new byte[1024];

                // пока не завершилось скачивание - (не вернуось -1) - скачиваем и записываем
                while ((bytesRead = inputStreams.read(buffer)) != -1)
                    // записываем в файл байты от 0 до "bytesRead" из массива "buffer"
                    outputStream.write(buffer,0,bytesRead);

            }else {
                System.out.println("Не удалось установить соединение с сервером.");
                exc = false;
            }
        // если в процессе установления соединения с сервером, либо, при записи данных в файл произошел сбой
        // - сообщанем об этом в соотв. ошибке
        }catch (Exception e){
            System.out.println("Ошибка "+e.toString());
            exc = false;
        // была ошибка или нет, а закрыть входной и выходной потоки необходимо в обязательном порядке.
        }finally {
            try {
                if (inputStreams != null) {
                    inputStreams.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }catch (Exception e){
                System.out.println("Ошибка при закрытии стрима "+e.toString());
                exc = false;
            }
        }
        return exc;
    }


}
