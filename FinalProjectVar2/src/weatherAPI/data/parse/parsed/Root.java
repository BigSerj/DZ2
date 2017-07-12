package weatherAPI.data.parse.parsed;


import java.util.ArrayList;

import static weatherAPI.domain.checks.DatesFormat.convertDate;


public class Root {

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
        return "parsed (name=" + name + ", date=" + convertDate(date)+ ", weather=" + weather + ")";
    }
}
