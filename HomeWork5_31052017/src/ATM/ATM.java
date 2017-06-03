package ATM;

public class ATM {

    ATM(int m20, int m50, int m100) {
        this.m20 = m20;
        this.m50 = m50;
        this.m100 = m100;
    }

    private int m20;
    private int m50;
    private int m100;


    public int getM20() {
        return m20;
    }

    public void setM20(int m20) {
        this.m20 = m20;
    }

    public int getM50() {
        return m50;
    }

    public void setM50(int m50) {
        this.m50 = m50;
    }

    public int getM100() {
        return m100;
    }

    public void setM100(int m100) {
        this.m100 = m100;
    }


    //добавление денег в банкомат (в банкомат деньги ложатся по одной купюре,значит, смотрим, какая купюра пришла и добавляем)
    public static void addMoney(ATM atmName, int newNote) {
        switch (newNote) {
            case 20:
                atmName.setM20(atmName.getM20() + 1);
                break;
            case 50:
                atmName.setM50(atmName.getM50() + 1);
                break;
            case 100:
                atmName.setM100(atmName.getM100() + 1);
        }
        System.out.printf("Купюра %d успешно добавлена.%n", newNote);
        showSum(atmName);
    }


    //снятие денег из банкомата
    public static boolean withdrawMoney2Var(ATM atmName, int withdrawSumMoney) {
        if (withdrawSumMoney < 20)
            System.out.printf("%nМинимальная сумма для выдачи: 20.%n%n");
        else if (withdrawSumMoney > getSum20(atmName) + getSum50(atmName) + getSum100(atmName)) {
            System.out.printf("%nНа Вашем счете недостаточно средств для выдачи запрашиваемой Вами суммы.%n");
            showSum(atmName);
        } else if (withdrawSumMoney % 10 != 0 || (withdrawSumMoney % 20 != 0 && withdrawSumMoney < 50))
            printAlertNotAoughNotes();
        else {
            int[] kolNotes = {atmName.getM20(), atmName.getM50(), atmName.getM100()};
            int withdrawSumMoneyNew = withdrawSumMoney;//дублируем, чтобы не забывать введенное значение суммы на выдачу (можно и не дублировать)
            int flagChanges;//флаг о присутствии действия в цикле
            do {
                flagChanges = withdrawSumMoneyNew;
                if (withdrawSumMoneyNew % 20 != 0) {
                    if (kolNotes[1] >= 1) {
                        kolNotes[1]--;
                        withdrawSumMoneyNew -= 50;
                    } else
                        printAlertNotAoughNotes();
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
                        printToScreen(kolNotes, atmName);
                        return true;
                    }
                }
            } while (flagChanges != withdrawSumMoneyNew);//проверяем на то, происхошло ли изменение в итерации. Если нет - выходим из цикла с ошибкой
            printAlertNotAoughNotes();

        }
        return false;
    }


    //вывод счета и оставшихся купюр на экран
    public static void showSum(ATM atmName) {
        System.out.printf("На Вашем счете осталось: %d%n", getSum20(atmName) + getSum50(atmName) + getSum100(atmName));
        System.out.printf("В банкомате осталось купюр:%n-номиналом 20: %d%n", atmName.getM20());
        System.out.printf("-номиналом 50: %d%n", atmName.getM50());
        System.out.printf("-номиналом 100: %d%n%n", atmName.getM100());
    }


    private static void printToScreen(int[] kolNotes, ATM atmName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Вы сняли со счета купюры:  ");
        if (atmName.getM100() - kolNotes[2] != 0) {
            sb.append(atmName.getM100() - kolNotes[2]);
            sb.append(" номиналом 100.  ");
            atmName.setM100(kolNotes[2]);
        }
        if (atmName.getM50() - kolNotes[1] != 0) {
            sb.append(atmName.getM50() - kolNotes[1]);
            sb.append(" номиналом 50.  ");
            atmName.setM50(kolNotes[1]);
        }
        if (atmName.getM20() - kolNotes[0] != 0) {
            sb.append(atmName.getM20() - kolNotes[0]);
            sb.append(" номиналом 20.");
            atmName.setM20(kolNotes[0]);
        }
        System.out.printf("%n%s%n%n",sb.toString());
    }


    //выводим на экран сумму и количество купюр:
    private static void printAlertNotAoughNotes() {
        System.out.println("Невозможно выдать запрашиваемую сумму: недостаточное количество купюр необходимого номинала.");
    }


    private static int getSum20(ATM atmName) {
        return atmName.getM20() * 20;
    }

    private static int getSum50(ATM atmName) {
        return atmName.getM50() * 50;
    }

    private static int getSum100(ATM atmName) {
        return atmName.getM100() * 100;
    }
}
