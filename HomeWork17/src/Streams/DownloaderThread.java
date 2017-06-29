package Streams;

/**
 * Этот поток скачивает JSON, затем ждет, пока его распарсит другой поток
 * затем скачиавает XML и снова ждет пока его распарсит другой поток.
 */
public class DownloaderThread extends Thread {

    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }


    @Override
    public void run(){

        // скачиваем XML
        System.out.println("Скачиваем XML");
        try {
            HTTPUrlConnectorClass.inputStreamClass(Constants.LINK_XML);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла XML. \""+e.toString()+"\"");
        }

        // пробуждаем поток парсера
        System.out.println("Пробуждаем поток парсера");
        synchronized (parserThread) {
            // пробуждаем поток парсера
            System.out.println("DownloaderThread - пробуждаем поток парсера");
            parserThread.notifyAll();
        }

        // затем сами засыпаем
        synchronized (this) {
            System.out.println("DownloaderThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }



        // скачиваем JSON
        System.out.println("Скачиваем JSON");
        try {
            HTTPUrlConnectorClass.inputStreamClass(Constants.LINK_JSON);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла JSON. \""+e.toString()+"\"");
        }

        // пробуждаем поток парсера
        System.out.println("Пробуждаем поток парсера");
        synchronized (parserThread) {
            // пробуждаем поток парсера
            System.out.println("DownloaderThread - пробуждаем поток парсера");
            parserThread.notifyAll();
        }


        System.out.println("DownloaderThread - завершаем работу");


    }
}
