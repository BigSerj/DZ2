package Task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Formats {

    public static void main(String[] args) {

        // Вводим файл
        Scanner in = new Scanner(System.in);
        String str = in.next();

        // отрезаем формат
        getFileFormat(str);

        // проверяем формат на json/xml
        isCorrectFormat(str);
    }


    // отрезаем формат
    public static void getFileFormat(String str){
        Pattern p1 = Pattern.compile("((?=\\.(\\w+))\\.\\2)");
        Matcher m2 = p1.matcher(str);
        if (m2.find())
            System.out.println(m2.group().replace(".",""));
    }



    // проверяем формат на json/xml
    public static void isCorrectFormat(String str){
        Pattern p = Pattern.compile("((?=\\.(json|xml))\\.\\2)");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println("Верный формат");
        }else
            System.out.println("Неверный формат");
    }



}