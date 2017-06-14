package Task3_AtLesson10_txt;

import java.io.FileNotFoundException;

public class MinHosp {

    private static String fileName = "/Flash/JAVA for ANDROID/aa.txt";

    public static void main(String[] args) throws FileNotFoundException {
        //Чтение файла

        Doctor d1 = new Doctor();
        Doctor d2 = new Doctor();
        Doctor d3 = new Doctor();
        Doctor d4 = new Doctor();
        Doctor[] d = {d1,d2,d3,d4};

        ReadWrite.read(fileName,d);

        System.out.println("имена: ");
        System.out.println(d1.getName());
        System.out.println(d2.getName());
        System.out.println(d3.getName());
        System.out.println(d4.getName());
        System.out.println("возраст: ");
        System.out.println(d1.getAge());
        System.out.println(d2.getAge());
        System.out.println(d3.getAge());
        System.out.println(d4.getAge());
        System.out.println("доктор?: ");
        System.out.println(d1.isUchastkoviy());
        System.out.println(d2.isUchastkoviy());
        System.out.println(d3.isUchastkoviy());
        System.out.println(d4.isUchastkoviy());



    }


    public static void callMyTest(People p) {
        p.myTest();
    }


}


/*
    Абстракция - когда берем из объекта класса только то, что кадо, абстрагируеясь от всего остального содержимого этого класа.
    Наследование - наследование классов одного от другого.
    Инкапсуляция - введение ограничений на видимость переменных, методов, классов. Зоны их видимости.
    Полиморфизм - см. занятие за 02.06.2017.

 */