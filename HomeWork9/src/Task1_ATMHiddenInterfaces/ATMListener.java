package Task1_ATMHiddenInterfaces;


public interface ATMListener {
    void addMoneyInt(int newNote);
    boolean withdrawMoney2VarInt(int withdrawSumMoney);
    void showSumInt();
    void showAlert(int numbAlert);
}
