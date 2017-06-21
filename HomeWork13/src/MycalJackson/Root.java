package MycalJackson;

import java.util.ArrayList;

public class Root {

    private String name;
    private String date;
    private ArrayList<Weather> weatherList;

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

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }


    @Override
    public String toString() {
        return "Root (name=" + name + ", date=" + date + ",weatherList=" + weatherList + ")";
    }




}
