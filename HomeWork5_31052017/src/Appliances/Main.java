package Appliances;


public class Main {
    public static void main(String[] args) {
        Mixers m1 = new Mixers();
        m1.setClearance(2);

        MeatGrinders mg1 = new MeatGrinders();
        mg1.setName("Лучший миксер!");

        System.out.println(m1.getClearance());
        System.out.println(mg1.getName());
    }
}
