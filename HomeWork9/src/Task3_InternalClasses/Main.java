package Task3_InternalClasses;

public class Main {

    public static void main(String[] args) {

        City newPolotsk = new City();

        newPolotsk.avenue.name = "Строителей";
        newPolotsk.street.name = "Якуба Коласа";
        newPolotsk.prospect.name = "Молодежная";


        City minsk = new City();

        minsk.avenue.name = "Победы";
        minsk.street.name = "Слободская";
        minsk.prospect.name = "Держинского";
        minsk.avenue2.name = "Независимости";
        minsk.street2.name = "Клары Цепкин";
        minsk.prospect2.name = "Победителей";




        System.out.println(newPolotsk.avenue.name);
        System.out.println(minsk.avenue2.name);
        System.out.println(newPolotsk.prospect.name);
        System.out.println(minsk.street.name);


    }

}
