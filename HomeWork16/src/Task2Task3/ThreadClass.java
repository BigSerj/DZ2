package Task2Task3;

import java.util.ArrayList;

public class ThreadClass extends Thread {

    @Override
    public void run(){

        ArrayList<Integer> list10;
        for (int j=1;j<=10;j++) {
            list10 = new ArrayList<>();
            for (int i = j*10-9; i <= j*10; i++)
                list10.add(i);


            Main.print10(this, list10);
        }

    }



}
