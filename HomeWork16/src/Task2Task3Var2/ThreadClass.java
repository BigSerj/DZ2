package Task2Task3Var2;

public class ThreadClass extends Thread {

    @Override
    public void run(){
        for (int i=0;i<100;i++)
            Main.print10(getName());
    }



}
