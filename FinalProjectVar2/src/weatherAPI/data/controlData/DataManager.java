package weatherAPI.data.controlData;


import weatherAPI.data.parse.parsed.Root;
import weatherAPI.data.parse.parsers.GSONParse;
import weatherAPI.data.parse.parsers.JSONParse;
import weatherAPI.data.parse.parsers.Parse;
import weatherAPI.data.parse.parsers.ParseXML;
import static weatherAPI.domain.checks.ScannerIn.scannerToString;


public class DataManager {

    // создаем синглтон контроллер управления скачиванием и парсинга
    private static DataManager ourInstance = new DataManager();
    public static DataManager getInstance() {
        return ourInstance;
    }
    private DataManager() {
        root = new Root();
    }


    // создаем тут же бъект root
    private Root root;
    public Root getRoot() {
        return root;
    }


    // создаем объект парсинга
    private Parse parser;
    public Parse getParser() {
        return parser;
    }

    public void setParser() {
        Parse parser = null;
        switch (scannerToString()) {
            case 1:
                parser = new JSONParse();
                break;
            case 2:
                parser = new GSONParse();
                break;
            case 3:
                parser = new ParseXML();
        }
        this.parser = parser;
    }
}