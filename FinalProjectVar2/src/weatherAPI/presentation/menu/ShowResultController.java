package weatherAPI.presentation.menu;


import weatherAPI.data.parse.parsed.Weather;
import weatherAPI.domain.manager.MenuTask;
import weatherAPI.presentation.constants.MessagesConst;
import java.util.ArrayList;

// контроллер вывода на экран
public class ShowResultController {

    private ShowResult view;
    private MenuTask modelMenu;


    public ShowResultController(ShowResult view, MenuTask modelMenu){
        this.view = view;
        this.modelMenu = modelMenu;
    }

    // геттеры сеттеры для контроллера
    public void setModelMenuInputNumber(){
        modelMenu.setInputNumber();
    }
    public Integer getModelMenuInputNumber(){
        return modelMenu.getInputNumber();
    }
    public void setModelMenuMenuTasks(MessagesConst thisMenuEnum){
        modelMenu.setMenuTask(thisMenuEnum);
    }
    public MessagesConst getModelMenuMenuTasks(){
        return modelMenu.getMenuTask();
    }

    // определяем методы
    public void updateViewMain(){
        view.toScreenMain();
    }
    public void updateView1(ArrayList<Weather> newWeather){
        view.toScreen(newWeather);
    }
    public void updateView2(ArrayList<String> locationFind){
        view.toScreen2(locationFind);
    }
    public void updateView3(Integer[] locationFind){
        view.toScreen3(locationFind);
    }

}