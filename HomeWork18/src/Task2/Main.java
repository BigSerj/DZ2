package Task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) {

        MyTest myTest = new MyTest();

        Class clas = myTest.getClass();

        Field[] fields = clas.getDeclaredFields();


        System.out.println("Изменяем поля: ");

        for(Field f:fields) {
            try {
                f.setAccessible(true);
                switch (f.getName()) {
                    case "text":
                        f.set(myTest, "newName");
                        break;
                    case "a":
                        f.set(myTest, 23);
                        break;
                    case "bool":
                        f.set(myTest, true);
                        break;
                }
                System.out.println(f.getName()+"= " + f.get(myTest));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }


        System.out.println("\nВызываем геттеры: ");

        Method[] methods = clas.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.setAccessible(true);
                System.out.println(method.getName()+"= "+method.invoke(myTest));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }




    }

}