package MycalJackson;


import java.util.ArrayList;


public class Weather {

    public int id;
    public String title;
    public String description;
    public int temp_min;
    public int temp_max;
    public int humidity;
    public String date;
    public ArrayList<String> location;



    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }


    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "\nWeather [\nid=" + id+ ", \ntitle=" + title + ", \ndescription="
                + description + ", \ntempMin=" + temp_min + ", \ntempMax=" + temp_max + ", \nhumidity=" + humidity +
                ", \ndate=" + date + ", \nlocation [" + locationPrint(location) + "]\n]";
    }

    public String locationPrint(ArrayList<String> location){
        String returnVal="";
        for (int i=0;i<location.size();i++) {
            returnVal += location.get(i);
            if (i!=location.size()-1)
                returnVal+="\n";
        }
        return returnVal;
    }

}
