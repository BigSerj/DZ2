package Weather;


import java.util.ArrayList;
import static Weather.DateMethods.convertDate;


public class Root {

    // делаем Root singleton
    private static Root root = new Root();
    public static Root getInstance(){
        return root; // возвращаем уже созданный root
    }
    private Root() {
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
        return "Root (name=" + name + ", date=" + convertDate(date)+ ", weather=" + weather + ")";
    }




}
