package Task1_ATMHiddenInterfaces;

public class ATM {

    private ATMListener listener;

    public void setListener(ATMListener listener) {
        this.listener = listener;
    }


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
    public void addMoney(int newNote) {
        System.out.println(obrabotkaZaprosa());
        listener.addMoneyInt(newNote);
    }


    //снятие денег из банкомата
    public void withdrawMoney2Var(int withdrawSumMoney) {
        System.out.println(obrabotkaZaprosa());
        listener.withdrawMoney2VarInt(withdrawSumMoney);
    }


    //вывод счета и оставшихся купюр на экран
    public void showSum() {
        System.out.println(obrabotkaZaprosa());
        listener.showSumInt();
    }




    private static String obrabotkaZaprosa(){
        return "Обработка запроса...";
    }



    public int getSum20() {
        return m20 * 20;
    }

    public int getSum50() {
        return m50 * 50;
    }

    public int getSum100() {
        return m100 * 100;
    }



}
