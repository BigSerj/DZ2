package GarbageCollector;

public class Main1 {

    private int a = 5;

    public static void main(String[] args) {
        int b=7;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
