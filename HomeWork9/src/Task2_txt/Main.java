package Task2_txt;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    //private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
    private static String fileName = "/Flash/JAVA for ANDROID/a.txt";

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Введите то, что Вы хотите сохранить в файл (000 - завершение ввода):");
        //запись в файл и создание файла
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String ooo = "";
        while(!Objects.equals(ooo, "000")){
            ooo = in.next();
            sb.append(ooo);
        }
        ReadWrite.write(fileName,sb.toString());


        //Чтение файла
        String textFromFile = ReadWrite.read(fileName);
        System.out.println(textFromFile);

    }

}
