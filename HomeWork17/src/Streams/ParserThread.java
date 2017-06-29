package Streams;

/**
 * Этот поток сначала ждет, пока парсится JSON, затем парсит его.
 * затем ждет пока другой поток скачиавает XML и потом ЭТОТ поток парсит его.
 */
public class ParserThread extends Thread{

    private DownloaderThread downloaderThread;

    Parse parseXML = new ParseXML();
    Parse parseJSON = new JSONParse();


    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }


    @Override
    public void run(){

        // сразу засыпаем и ждем, пока downloaderThread не вызовет у нас notify()
        synchronized (this) {
            System.out.println("ParserThread - сразу сами засыпаем");
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        // парсим XML
        System.out.println("ParserThread - парсим XML:");
        try {
            System.out.println("\n\n\n"+parseXML.parseThis()+"\n\n\n");
        } catch (Exception e) {}

        // пробуждаем поток скачки
        System.out.println("Пробуждаем поток скачки");
        synchronized (downloaderThread) {
            // пробуждаем поток скачки
            System.out.println("ParserThread - пробуждаем поток скачки");
            downloaderThread.notifyAll();
        }

        // затем сами засыпаем
        synchronized (this) {
            System.out.println("ParserThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }


        // парсим JSON
        System.out.println("Парсим JSON:");
        try {
            System.out.println("\n\n\n"+parseJSON.parseThis()+"\n\n\n");
        } catch (Exception e) {}



        System.out.println("ParserThread - завершаем работу");




    }

}
