package Calc_Task1_2;

public class MyExceptions extends Exception{

    private int codeEx;

    public MyExceptions(int codeEx) {
        this.codeEx = codeEx;
    }

    public int getCodeEx() {
        return codeEx;
    }

    public void getRussianMessage(){

        if (codeEx==1)
            System.out.println("Введите целое число!");
        else if (codeEx==2)
            System.out.println("Введите целое число от 1 до 4  (1 - сложение(a+b), 2 - вычитание(a-b), 3 - умножение(a+b), 4 - деление(a/b)): ");
        else if (codeEx==11)
            System.out.println("Ошибка сложения");
        else if (codeEx==12)
            System.out.println("Ошибка вычитания");
        else if (codeEx==13)
            System.out.println("Ошибка умножения");
        else if (codeEx==14)
            System.out.println("Ошибка деления");

    }


}
