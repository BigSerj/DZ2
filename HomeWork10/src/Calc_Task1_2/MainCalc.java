package Calc_Task1_2;

public class MainCalc {

    public static void main(String[] args) {

        System.out.println("Введите число a: ");
        int a = MathFunctions.inMethodScanner(0);

        System.out.println("Введите число b: ");
        int b = MathFunctions.inMethodScanner(0);

        System.out.println("Введите 1 - сложение(a+b), 2 - вычитание(a-b), 3 - умножение(a+b), 4 - деление(a/b): ");
        int c = MathFunctions.inMethodScanner(3);

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("Результат: ").append(MathFunctions.switchMethodFunc(a, b, c)));

    }
}
