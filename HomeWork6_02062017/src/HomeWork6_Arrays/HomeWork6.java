package HomeWork6_Arrays;

import java.util.ArrayList;
import java.util.Random;

public class HomeWork6 {
    public static void main(String[] args) {

        int[] array1 = new int[10];
        int[] array2 = new int[20];
        int arraysScope = 9;
        Random arrayVal = new Random();
        for (int i = 0; i < 20; i++) {
            if (i < 10)
                array1[i] = arrayVal.nextInt(arraysScope);
            array2[i] = arraysScope + arrayVal.nextInt(99 - arraysScope);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Массив который вставляем: \n[");
        printArrays(sb, array1);

        sb.delete(0, sb.length()).append("\nМассив в который вставляем: \n[");
        printArrays(sb, array2);

        System.arraycopy(array1, 0, array2, array2.length / 4, array1.length);

        sb.delete(0, sb.length()).append("\nИтоговый массив: \n[");
        printArrays(sb, array2);

    }

    private static void printArrays(StringBuilder sb, int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            sb.append(array[i]).append(", ");
        sb.append(array[array.length-1]).append("]");
        System.out.println(sb.toString());
    }
}
