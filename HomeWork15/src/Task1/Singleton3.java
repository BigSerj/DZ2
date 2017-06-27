package Task1;

public class Singleton3 {

    private Singleton3(){}

    private static class SingletonHelper{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHelper.INSTANCE;
    }

}
