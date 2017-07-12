/**
 * Created by bigserj on 10.07.17.
 */
public class ddd {

    static String a = "1";

    static ddd getD(){
        System.out.println("2");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getD().a);
    }

}