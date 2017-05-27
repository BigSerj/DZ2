import java.util.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bigserj on 27.05.17.
 */
public class HomeWork3_26052017 {
    public static void main(String[] args) {




        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 1.0
        System.out.printf("Task 1:%n");
        //Создайте массив с 10-ю переменными типа int.
        Integer[] mas1 = new Integer[10];
        //Значения необходимо вводить с клавиатуры в отдельном методе.
        System.out.printf("%nВведите элементы массива с клавиатуры (%d %s): %n",mas1.length,RughtNameOfElementsOfMassive(mas1.length));
        mas1 = ScannerFunc(mas1);
        //Затем выведите все значения на экран также в отдельном методе в виде: "значение" | "значение 2" | "значение 3" |  и тд. -
        System.out.printf("%nВведенный Вами массив: %n");
        SoutFunc(mas1);
        //Далее отсортируйте массив по возрастанию одним из способов из статьи (или всеми:) ).
        //Результат вывести на экран: "значение" | "значение 2" | "значение 3" |  и тд.
        System.out.printf("%n%nВведите способ сортировки: \"1\"-Встроенная ф-я сортировки. \"2\" - Сортировка выбором. \"3\"-Cортировка пузырьком.%n");
        int sortSwitch1 = ScannerFunc();
        System.out.printf("Введите вид сортировки: \"1\"-По возрастанию. \"2\" - По убыванию.%n");
        int sortUpDown = ScannerFunc();
        System.out.printf("%nВы выбрали способ сортировки: \"%s\", вид сортировки: \"%s\"%n%nРезультат:%n",SposobSort(sortSwitch1),VidSort(sortUpDown));
        switch (sortSwitch1){
            case 1:
                if (sortUpDown == 1)
                    Arrays.sort(mas1);
                else if (sortUpDown == 2)
                    Arrays.sort(mas1, Collections.reverseOrder());
                SoutFunc(mas1);
                break;
            case 2:
                SoutFunc(SortSelection(mas1,sortUpDown));
                break;
            case 3:
                SoutFunc(SortBubble(mas1,sortUpDown));
                break;
        }
        //Далее найдите в массиве все четные числа и выведите их на экран: "значение" | "значение 2" | "значение 3" |  и тд.
        System.out.printf("%n%nВсе четные числа массива: %n");
        for (int i=0;i<mas1.length;i++){
            if (mas1[i]%2 == 0)
                SoutFunc(mas1[i]);
        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 1.0
    //Выбор слава и падежа
    private static String RughtNameOfElementsOfMassive(int masLeingth){
        return "элемент"+SelectRightWord(masLeingth);
    }
    private static String SelectRightWord(int masLeingth){
        switch (masLeingth){
            case 1: return "";
            case 2:case 3:case 4: return "а";
            default: return "ов";
        }
    }
    //Заполнение массива
    private static Integer[] ScannerFunc(Integer mas1[]){
        for (int i=0;i<mas1.length;i++)
            mas1[i] = ScannerFunc();
        return mas1;
    }
    //Считывание вводимого с клавиаутры
    private static Integer ScannerFunc(){
        System.out.print("Введите целое число с клавиатуры: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    //Вывод массива
    private static void SoutFunc(Integer mas1[]){
        for (int i=0;i<mas1.length;i++)
            SoutFunc(mas1[i]);
    }
    //Вывод элемента массива
    private static void SoutFunc(int mas1){
        System.out.printf("\"%d\" | ",mas1);
    }
    //сортировка пузырьком
    private static Integer[] SortBubble(Integer[] mas, int sortUpDown) {
        for (int i=mas.length-1;i>0;i--) {
            for (int j=0;j<i;j++){
                if((mas[j] > mas[j+1] && sortUpDown == 1) || (mas[j] < mas[j+1] && sortUpDown == 2)){
                    int tmp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = tmp;
                }
            }
        }
        return mas;
    }
    //сортировка выбором
    private static Integer[] SortSelection(Integer[] mas, int sortUpDown) {
        for (int i = 0; i < mas.length; i++) {
            int min = mas[i];
            int min_i = i;
            for (int j = i+1; j < mas.length; j++) {
                if ((mas[j] < min && sortUpDown == 1) || (mas[j] > min && sortUpDown == 2)) {
                    min = mas[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = mas[i];
                mas[i] = mas[min_i];
                mas[min_i] = tmp;
            }
        }
        return mas;
    }
    private static String SposobSort(int sortSwitch1){
        switch (sortSwitch1){
            case 1: return "Встроенная ф-я";
            case 2: return "Выбором";
            case 3: return "Пузырьком";
        }
        return "Не выбрано";
    }
    private static String VidSort(int sortUpDown){
        if (sortUpDown == 1) return "По возрастанию";
        else if (sortUpDown == 2) return "По убыванию";
        return "Не выбрано";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





}
















