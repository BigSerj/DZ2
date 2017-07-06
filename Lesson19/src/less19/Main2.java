package less19;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

    //private static ArrayList<?> list; // создаем ArrayList с неопределенным типом данных, чтобы потом создавать объекты листа типов какие нам нужны по месту.
    //private static ArrayList<? extends Number> list; // только числа, String  ит.п. нельзя
    private static ArrayList<? super Integer> list; // берем сам интеджер и то что выше - намбер.

    public static void main(String[] args) {

        list = new ArrayList<Integer>();
//        list = new ArrayList<Double>();
//        list = new ArrayList<String>();


    }

}
