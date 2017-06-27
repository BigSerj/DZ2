package Weather.Parse;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class GSONParse {

//    public static void main(String[] args) {
//        Root root = parseGson("weather.json");
//        System.out.println(root.toString());
//    }

    public static Root parseGson(String path){

        Root root = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root = gson.fromJson(reader, Root.class);
        }catch (Exception e){
            System.out.println("Ошбика чтения .json файла " + e.toString());
        }
        return root;
    }
}
