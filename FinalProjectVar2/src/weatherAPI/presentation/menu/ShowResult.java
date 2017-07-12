package weatherAPI.presentation.menu;


import weatherAPI.data.controlData.DataManager;
import weatherAPI.data.parse.parsed.Weather;
import java.util.ArrayList;
import static weatherAPI.domain.checks.Dates.convertDate;
import static weatherAPI.presentation.constants.MessagesConst.*;
import static weatherAPI.presentation.menu.ControlCentreMenu.showCurrentMenu;


public class ShowResult {

    // методы для вывода на экран
    public void toScreenMain(){
        System.out.println(showCurrentMenu(MAIN_MENU_SWITCH_TASK));
    }
    public void toScreen(ArrayList<Weather> newWeather){
        System.out.println("parsed (name=" + DataManager.getInstance().getRoot().getName() + ", date=" +
                convertDate(DataManager.getInstance().getRoot().getDate()) + ", weather=" + newWeather + ")");
    }
    public void toScreen2(ArrayList<String> locationFind){
        System.out.println(locationFind);
    }
    public void toScreen3(Integer[] locationFind){
        System.out.println("Средняя температура по ргеиону = " + locationFind[0]);
        System.out.println("Максимальная температура по ргеиону = " + locationFind[1]);
    }

}
