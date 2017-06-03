package ATM;

import java.util.Scanner;

public class MainLogic {
    public static void main(String[] args) {

        ATM newATM = new ATM(9, 8, 2);

        Scanner in = new Scanner(System.in);

        //логика
        while (true) {
            String barrier = "//////////////////////////////////////////////////////////////////";
            for (int i = 0; i < 3; i++)
                System.out.printf("%s%s%n", barrier, barrier);

            System.out.printf("Если хотите пополнить счет - введите '1'. %nЕсли хотите снять денег - введите '2'. %nЕсли хотите увидеть оставшуюся сумму - введите '3'.%n");

            switch (in.nextInt()) {
                case 1:
                    while (true) {//пока не введем код выхода из пополнения суммы
                        System.out.println(barrier);
                        System.out.print("Введите номинал купюры (20/50/100), которую Вы виртуально всовываете в банкомат, либо, введите '0' для выхода из меню пополнения счета: ");
                        int newVvod = in.nextInt();
                        if (newVvod == 0)
                            break;
                        else if (newVvod == 20 || newVvod == 50 || newVvod == 100)
                            ATM.addMoney(newATM, newVvod);
                        else
                            System.out.println("Неверный номинал купюры! Банкомат принимает только купюры, либо, 20, либо, 50, либо, 100!");
                    }
                    break;
                case 2:
                    while (true) {//пока не введем код выхода из снятия суммы
                        System.out.print("Введите сумму, которую Вы хотите снять со счета, либо, введите '0' для выхода из меню снятия денег: ");
                        int newVvod = in.nextInt();
                        if (newVvod == 0)
                            break;
                        else
                            //ATM.withdrawMoney(newATM, newVvod);
                            ATM.withdrawMoney2Var(newATM, newVvod);
                    }
                    break;
                case 3:
                    ATM.showSum(newATM);
                    break;
                default:
                    System.out.println("Введите корректное значение ( '1' / '2' / '3' )");
            }
            System.out.println("");
        }
    }
}
