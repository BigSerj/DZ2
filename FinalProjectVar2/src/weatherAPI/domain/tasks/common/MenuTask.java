package weatherAPI.domain.tasks.common;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.presentation.constants.MessagesConst;

import java.util.ArrayList;

import static weatherAPI.domain.checks.ScannerIn.scannerToString;
import static weatherAPI.domain.tasks.task1.SetDateForSearch.setDateForSearch;
import static weatherAPI.domain.tasks.task2.SetDatePeriodForSearch.setDatePeriodForSearch;
import static weatherAPI.domain.tasks.task4.SetCityForSearchWeather.setCityForSearchWeather;
import static weatherAPI.domain.tasks.task5.SortingByTempAndHumidity.sortingByTempAndHumidity;
import static weatherAPI.domain.tasks.task6.SearchCityByRangeOfTemp.searchCityByRangeOfTemp;
import static weatherAPI.domain.tasks.task7.SearchMiddleMaxTempInRegion.searchMiddleMaxTempInRegion;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


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
