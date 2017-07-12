package weatherAPI.domain.manager;


import weatherAPI.presentation.constants.MessagesConst;
import static weatherAPI.domain.checks.ScannerIn.scannerToString;


// класс-хранилка меню
public class MenuTask {

    private MessagesConst menuTasks;

    // переменная-хранитель вводной информации о том, какой номер меню выбрали
    private Integer inputNumber;

    // геттеры
    public Integer getInputNumber() {
        return inputNumber;
    }
    public MessagesConst getMenuTask() {
        return menuTasks;
    }

    // сеттеры
    public void setMenuTask(MessagesConst menuTasks) {
        this.menuTasks = menuTasks;
    }
    public void setInputNumber() {
        this.inputNumber = scannerToString();
    }

}