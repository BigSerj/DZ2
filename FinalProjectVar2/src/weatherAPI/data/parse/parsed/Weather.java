package weatherAPI.data.parse.parsed;


import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import static weatherAPI.domain.checks.Dates.checkDate;
import static weatherAPI.domain.checks.Dates.convertDate;


public class Weather {

    private int id;
    private String title;
    private String description;

    @SerializedName("temp_min")
    private int tempMin;

    @SerializedName("temp_max")
    private int tempMax;

    private int humidity;
    private String date;
    private ArrayList<String> location;



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

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
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
        this.date = checkDate(date);
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }



    @Override
    public String toString() {
        return "\nweatherAPI [\nid=" + id+ ", \ntitle=" + title + ", \ndescription="
                + description + ", \ntempMin=" + tempMin + ", \ntempMax=" + tempMax + ", \nhumidity=" + humidity +
                ", \ndate=" + convertDate(date) + ", \nlocation [" + locationPrint(location) + "]\n]";
    }

    // метод вывода на экран значений корзины location
    private String locationPrint(ArrayList<String> location){
        String returnVal="";
        for (int i=0;i<location.size();i++) {
            returnVal += location.get(i);
            if (i!=location.size()-1)
                returnVal+=", ";
        }
        return returnVal;
    }

}
