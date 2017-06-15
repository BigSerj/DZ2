package Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MainFIO {

    public static void main(String[] args) {

        ArrayList manMasList = new ArrayList();
        ArrayList womanMasList = new ArrayList();

        for (int i=0;i<9;i++)
            manMasList.add(new FIOClass("ManФ"+(i+1),"ManИ"+(i+1),"ManО"+(i+1)));

        for (int i=0;i<10;i++)
            womanMasList.add(new FIOClass("WomanФ"+(i+1),"WomanИ"+(i+1),"WomanО"+(i+1)));

        //выводим на экран оба массива
        System.out.println("////////////////////////////////////////");
        for (int i=0;i<manMasList.size();i++) {
            System.out.println("/// Мужчина "+(i+1));
            System.out.println(((FIOClass)manMasList.get(i)).getNameF());
            System.out.println(((FIOClass)manMasList.get(i)).getNameI());
            System.out.println(((FIOClass)manMasList.get(i)).getNameO());
        }
        System.out.println("////////////////////////////////////////");
        for (int i=0;i<womanMasList.size();i++) {
            System.out.println("/// Женщина "+(i+1));
            System.out.println(((FIOClass)womanMasList.get(i)).getNameF());
            System.out.println(((FIOClass)womanMasList.get(i)).getNameI());
            System.out.println(((FIOClass)womanMasList.get(i)).getNameO());
        }
        System.out.println("////////////////////////////////////////");
        System.out.println("////////////////////////////////////////");


        // записываем в HashMap
        HashMap<String, ArrayList> hashMap = new HashMap<>();
        hashMap.put("man",manMasList);
        hashMap.put("woman",womanMasList);


        // вводим man либо woman с консоли и выводим рандомно ФИО из соответствующего введенному ключу массива
        String inScanner = "";
        while (!(inScanner.equals("фсйо"))){
            System.out.println("/// Введите 'man', либо, 'woman'. Для завершения программы введите 'фсйо'");
            Scanner in = new Scanner(System.in);
            inScanner = in.next();
            if (inScanner.equals("man") || inScanner.equals("woman")) {
                ArrayList listManOrWoman = hashMap.get(inScanner);
                int rand = new Random().nextInt(listManOrWoman.size()-1);
                System.out.println(((FIOClass)listManOrWoman.get(rand)).getNameF());
                System.out.println(((FIOClass)listManOrWoman.get(rand)).getNameI());
                System.out.println(((FIOClass)listManOrWoman.get(rand)).getNameO());
            }
        }
    }

}
