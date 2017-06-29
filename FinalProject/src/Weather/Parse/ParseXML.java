package Weather.Parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Weather.Constants;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;


public class ParseXML implements Parse{

    // переопределяем метод getPath() для ParseXML
    @Override
    public String getPath() {
        return Constants.LINK_XML;
    }

    // переопределяем метод parseThis() для ParseXML
    @Override
    public Root parseThis() {
        Document dom;

        // открываем скачанный файл для парсинга, если ошибка - Exception ее словит и выведет соотв. сообщ-е и вернет пустой root
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(Constants.LINK_ON_THIS_SYSTEM);
        }catch (Exception e){
            System.out.println("Ошибка открытия файла .xml "+e.toString());
            return null;
        }

        // Создаем экземпляр класса root
        Root root = Root.getInstance();

        // парсим файл
        Element element = dom.getDocumentElement();
        // берем имя записываем в root
        NodeList nameNodeList = element.getElementsByTagName("name");
        root.setName(nameNodeList.item(0).getFirstChild().getNodeValue());
        // берем дату записываем в root
        NodeList dateNodeList = element.getElementsByTagName("date");
        root.setDate(dateNodeList.item(0).getFirstChild().getNodeValue());
        // создаем лист для элементов массива weather
        ArrayList<Weather> weatherList = new ArrayList<>();

        // разбираем поэлементно каждый элемент массива weather. Берем все теги с именем 'element' и перебираем каждый
        NodeList nList = element.getElementsByTagName("element");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // отделяем element weather`а от element`а - в файле есть 2 вида данных под тэгом 'element'
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

                    // создаем и заполняем лист с "location" очередного элемента weather
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

                    // добавляем данный распарсенный элемента массива weather из файла в нашу корзину
                    weatherList.add(weather);
                }
            }
        }
        // добавляем нашу заполненную корзину weather в root
        root.setWeather(weatherList);

        return root;
    }
}

