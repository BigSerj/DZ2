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

        // скачиваем JSON
        System.out.println("Скачиваем JSON");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

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



        // скачиваем XML
        System.out.println("Скачиваем XML");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

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
