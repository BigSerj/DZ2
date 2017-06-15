package Task1Task2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainTask1Task2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while(true){
            System.out.println("Введите элемент массива с индексом "+list.size()+" (для окончания ввода введите 'фсйо'): ");
            String ooo = in.next();
            if (Objects.equals(ooo, "фсйо"))
                break;
            list.add(ooo);
        }

        //выводим на экран ДО удаления "a"
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("///////////////////   ДО удаления \"a\" (Введенный массив):");
        for (String aList1 : list) System.out.println(aList1);
        System.out.println("////////////////////////////////////////////////////////");

        //удаляем буквы "а" в каждой строке массива
        for (int i=0;i<list.size();i++)
            list.set(i, list.get(i).replaceAll("а","").replaceAll("a",""));

        //выводим на экран ПОСЛЕ удаления "a"
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("///////////////////   ПОСЛЕ удаления \"a\":");
        for (String aList : list) System.out.println(aList);
        System.out.println("////////////////////////////////////////////////////////");


        // удаление дубликатов массива
        int xSize = list.size();
        for (int i=0;i<xSize-1;i++){
            for (int j=xSize-1;j>i;j--){
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    xSize--;
                    j--;
                }
            }
        }


        //выводим на экран ПОСЛЕ удаления дубликатов массива
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("///////////////////   ПОСЛЕ удаления дубликатов массива:");
        for (String aList : list) System.out.println(aList);
        System.out.println("////////////////////////////////////////////////////////");

    }

}