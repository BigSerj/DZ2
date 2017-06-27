package Task2Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class NewsAgence extends Observable implements Publisher {

    private List<Observer> channels = new ArrayList<>();

    public void addNews(String newsItem) {

        for(Observer outlet: this.channels) {

            outlet.update(this, newsItem);

        }

    }

    public void register(Observer outlet) {

        channels.add(outlet);

    }

}
