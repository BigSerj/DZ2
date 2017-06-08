package ATM;

import java.util.Scanner;

public class MainLogic implements ATMListener{

    private ATM newATM;

    public static void main(String[] args) {

        MainLogic main = new MainLogic();

        main.newATM = new ATM(10, 5, 0);

        main.newATM.setListener(main);

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
                            main.newATM.addMoney(newVvod);
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
                            main.newATM.withdrawMoney2Var(newVvod);
                    }
                    break;
                case 3:
                    main.newATM.showSum();
                    break;
                default:
                    System.out.println("Введите корректное значение ( '1' / '2' / '3' )");
            }
            System.out.println("");
        }
    }






    @Override
    public void addMoneyInt(int newNote) {
        switch (newNote) {
            case 20:
                newATM.setM20(newATM.getM20() + 1);
                break;
            case 50:
                newATM.setM50(newATM.getM50() + 1);
                break;
            case 100:
                newATM.setM100(newATM.getM100() + 1);
        }
        System.out.printf("Купюра %d успешно добавлена.%n", newNote);
        showSumInt();
    }




    @Override
    public boolean withdrawMoney2VarInt(int withdrawSumMoney) {
        if (withdrawSumMoney < 20)
            showAlert(-2);
            //System.out.printf("%nМинимальная сумма для выдачи: 20.%n%n");
        else if (withdrawSumMoney > newATM.getSum20() + newATM.getSum50() + newATM.getSum100()) {
            showAlert(-3);
            //System.out.printf("%nНа Вашем счете недостаточно средств для выдачи запрашиваемой Вами суммы.%n");
            showSumInt();
        } else if (withdrawSumMoney % 10 != 0 || (withdrawSumMoney % 20 != 0 && withdrawSumMoney < 50))
            showAlert(-1);
        else {
            int[] kolNotes = {newATM.getM20(), newATM.getM50(), newATM.getM100()};
            int withdrawSumMoneyNew = withdrawSumMoney;//дублируем, чтобы не забывать введенное значение суммы на выдачу (можно и не дублировать)
            int flagChanges;//флаг о присутствии действия в цикле
            do {
                flagChanges = withdrawSumMoneyNew;
                if (withdrawSumMoneyNew % 20 != 0) {
                    if (kolNotes[1] >= 1) {
                        kolNotes[1]--;
                        withdrawSumMoneyNew -= 50;
                    } else
                        showAlert(-1);
                }else {
                    if (withdrawSumMoneyNew >= 100) {
                        if (kolNotes[2] >= 1) {
                            kolNotes[2]--;
                            withdrawSumMoneyNew -= 100;
                        } else if (kolNotes[1] >= 2) {
                            kolNotes[1] -= 2;
                            withdrawSumMoneyNew -= 100;
                        } else if (kolNotes[0] >= 5) {
                            kolNotes[0] -= 5;
                            withdrawSumMoneyNew -= 100;
                        }
                    } else if ((withdrawSumMoneyNew >= 100 || withdrawSumMoneyNew == 50) && kolNotes[1] >= 1) {
                        kolNotes[1]--;
                        withdrawSumMoneyNew -= 50;
                    } else if (withdrawSumMoneyNew >= 20 && kolNotes[0] >= 1) {
                        kolNotes[0]--;
                        withdrawSumMoneyNew -= 20;
                    } else if (withdrawSumMoneyNew == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Вы сняли со счета купюры:  ");
                        if (newATM.getM100() - kolNotes[2] != 0) {
                            sb.append(newATM.getM100() - kolNotes[2]);
                            sb.append(" номиналом 100.  ");
                            newATM.setM100(kolNotes[2]);
                        }
                        if (newATM.getM50() - kolNotes[1] != 0) {
                            sb.append(newATM.getM50() - kolNotes[1]);
                            sb.append(" номиналом 50.  ");
                            newATM.setM50(kolNotes[1]);
                        }
                        if (newATM.getM20() - kolNotes[0] != 0) {
                            sb.append(newATM.getM20() - kolNotes[0]);
                            sb.append(" номиналом 20.");
                            newATM.setM20(kolNotes[0]);
                        }
                        System.out.printf("%n%s%n%n",sb.toString());
                        return true;
                    }
                }
            } while (flagChanges != withdrawSumMoneyNew);//проверяем на то, происхошло ли изменение в итерации. Если нет - выходим из цикла с ошибкой
            showAlert(-1);

        }
        return false;
    }



    @Override
    public void showSumInt() {
        System.out.printf("На Вашем счете осталось: %d%n", newATM.getSum20() + newATM.getSum50() + newATM.getSum100());
        System.out.printf("В банкомате осталось купюр:%n-номиналом 20: %d%n", newATM.getM20());
        System.out.printf("-номиналом 50: %d%n", newATM.getM50());
        System.out.printf("-номиналом 100: %d%n%n", newATM.getM100());
    }



    @Override
    public void showAlert(int numbAlert) {
        switch (numbAlert){
            case -1: System.out.println("Невозможно выдать запрашиваемую сумму: недостаточное количество купюр необходимого номинала."); break;
            case -2: System.out.printf("%nМинимальная сумма для выдачи: 20.%n%n"); break;
            case -3: System.out.printf("%nНа Вашем счете недостаточно средств для выдачи запрашиваемой Вами суммы.%n");
        }

    }


}
