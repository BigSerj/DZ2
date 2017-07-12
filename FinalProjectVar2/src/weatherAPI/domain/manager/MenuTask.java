package weatherAPI.domain.manager;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import static weatherAPI.domain.checks.ScannerIn.scannerToString;


// класс-хранилка меню
public class MenuTask {

    private MessagesConst menuTasks;

    // переменная-хранитель вводной информации о том, какой номер меню выбрали
    private Integer inputNumber;


    public Integer getInputNumber() {
        return inputNumber;
    }
    public void setInputNumber() {
        this.inputNumber = scannerToString();
    }


    public MessagesConst getMenuTask() {
        return menuTasks;
    }
    public void setMenuTask(MessagesConst menuTasks) {
        this.menuTasks = menuTasks;
    }

}
