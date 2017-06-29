package Task2Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ThreadClass thread1 = new ThreadClass();
        ThreadClass thread2 = new ThreadClass();
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        Scanner in = new Scanner(System.in);
        String inStr = in.next();
        if (inStr.equals("start")){
            thread1.start();
            thread2.start();
        }
    }


    // Task2
    public static void print10(Thread thread,ArrayList<Integer> list10){
        StringBuffer sb = new StringBuffer();
        sb.append(thread.getName()).append(":  ");
        for (Integer aList10 : list10) sb.append(aList10).append(" ");
        System.out.println(sb.toString());
    }

    // Task3
//    public synchronized static void print10(Thread thread,ArrayList<Integer> list10){
//        StringBuilder sb = new StringBuilder();
//        sb.append(thread.getName()).append(":  ");
//        for (Integer aList10 : list10) sb.append(aList10).append(" ");
//        System.out.println(sb.toString());
//    }

}
