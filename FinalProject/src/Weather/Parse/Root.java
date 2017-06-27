package Weather.Parse;

import java.util.ArrayList;

public class Root {

    // делаем Root singleton
    private static Root root;
    private Root() {
    }
    public static Root getInstance(){
        if (root==null)  // если root еще не существует - создаем новый объект root.
            return new Root();
        return root; // а если уже есть созданный root - возвращаем этот созданный root
    }


    private String name;
    private String date;
    private ArrayList<Weather> weather;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }


    @Override
    public String toString() {
        return "Root (name=" + name + ", date=" + date + ",weather=" + weather + ")";
    }




}
