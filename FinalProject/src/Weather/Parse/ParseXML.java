package Weather.Parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class ParseXML {

//    public static void main(String[] args) {
//        Root root = parseXML("weather.xml");
//        System.out.println(root.toString());
//    }

    public static Root parseXML(String path){
        Document dom = null;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(path);
        }catch (Exception e){
            System.out.println("Ошибка открытия файла .xml "+e.toString());
            return null;
        }


        Root root = Root.getInstance();

        Element element = dom.getDocumentElement();

        NodeList nameNodeList = element.getElementsByTagName("name");
        root.setName(nameNodeList.item(0).getFirstChild().getNodeValue());

        NodeList dateNodeList = element.getElementsByTagName("date");
        root.setDate(dateNodeList.item(0).getFirstChild().getNodeValue());

        ArrayList<Weather> weatherList = new ArrayList<>();


        NodeList nList = element.getElementsByTagName("element");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // отделяем element weather`а от element`а
                if (eElement.getElementsByTagName("date").item(0)!=null) {
                    Weather weather = new Weather();
                    weather.setDate(eElement.getElementsByTagName("date").item(0).getTextContent());//ставим дату

                    // не пустое ли поле "description", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node descriptionNode = eElement.getElementsByTagName("description").item(0);
                    weather.setDescription(descriptionNode.getTextContent());

                    // не пустое ли поле "humidity", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node humidityNode = eElement.getElementsByTagName("humidity").item(0);
                    if (humidityNode == null)
                        weather.setHumidity(0);
                    else
                        weather.setHumidity(Integer.parseInt(humidityNode.getTextContent()));

                    // не пустое ли поле "id", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node idNode = eElement.getElementsByTagName("id").item(0);
                    if (idNode == null)
                        weather.setId(0);
                    else
                        weather.setId(Integer.parseInt(idNode.getTextContent()));


                    NodeList locationNodeList = eElement.getElementsByTagName("location");
                    ArrayList<String> locationNodeArray = new ArrayList<>();
                    for (int j=0;j<locationNodeList.getLength();j++)
                        if (locationNodeList.item(j).getNodeType()==Node.ELEMENT_NODE)
                            locationNodeArray.add(locationNodeList.item(j).getTextContent());
                    weather.setLocation(locationNodeArray);


                    // не пустое ли поле "temp_max", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node tempMaxNode = eElement.getElementsByTagName("temp_max").item(0);
                    if (tempMaxNode == null)
                        weather.setTempMax(0);
                    else
                        weather.setTempMax(Integer.parseInt(tempMaxNode.getTextContent()));

                    // не пустое ли поле "temp_min", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node tempMinNode = eElement.getElementsByTagName("temp_min").item(0);
                    if (tempMinNode == null)
                        weather.setTempMin(0);
                    else
                        weather.setTempMin(Integer.parseInt(tempMinNode.getTextContent()));

                    // не пустое ли поле "title", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node titleNode = eElement.getElementsByTagName("title").item(0);
                    if (titleNode == null)
                        weather.setTitle("");
                    else
                        weather.setTitle(titleNode.getTextContent());


                    weatherList.add(weather);
                }
            }
        }
        root.setWeather(weatherList);

        return root;
    }
}

