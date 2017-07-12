package weatherAPI.data.manager;


import weatherAPI.data.parse.parsed.Root;

public class DataManager {
    private static DataManager ourInstance = new DataManager();
    public static DataManager getInstance() {
        return ourInstance;
    }
    private DataManager() {
        root = new Root();
    }

    private Root root;

    public Root getRoot() {
        return root;
    }
}
