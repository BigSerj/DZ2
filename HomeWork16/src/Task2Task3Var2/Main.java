package Task2Task3Var2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Thread thread = new ThreadClass();
        thread.setName("thread 1");
        Thread thread2 = new ThreadClass();
        thread2.setName("thread 2");

        Scanner in = new Scanner(System.in);
        String inStr = in.next();
        if (inStr.equals("start")){
            thread.start();
            thread2.start();
        }

    }

    public static void print10(String name){
        for (int i=0;i<10;i++)
            System.out.println(name+" "+i);
    }

//    public synchronized static void print10(String name){
//        for (int i=0;i<10;i++)
//            System.out.println(name+" "+i);
//    }

}
