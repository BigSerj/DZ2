package weatherAPI.data.parse.parsers;


import weatherAPI.data.manager.DataManager;
import weatherAPI.data.constants.LinksConst;
import weatherAPI.data.constants.TagsConst;
import weatherAPI.data.parse.parsed.Root;
import weatherAPI.data.parse.parsed.Weather;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;


public class ParseXML implements Parse{

    // переопределяем метод getPath() для ParseXML
    @Override
    public String getPath() {
        return LinksConst.LINK_XML;
    }

    // переопределяем метод parsing() для ParseXML
    @Override
    public void parsing() {
        Document dom;

        // открываем скачанный файл для парсинга,
        // если ошибка - Exception ее словит и выведет соотв. сообщ-е и вернет пустой parsed
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(LinksConst.LINK_ON_THIS_SYSTEM);
//            dom = db.parse("weather.xml");
        }catch (Exception e){
            System.out.println("Ошибка открытия файла .xml "+e.toString());
            return;
        }

        // Создаем экземпляр класса parsed
        Root root = DataManager.getInstance().getRoot();

        // парсим файл
        Element element = dom.getDocumentElement();
        // берем имя записываем в parsed
        NodeList nameNodeList = element.getElementsByTagName(TagsConst.NAME_TAG);
        root.setName(nameNodeList.item(0).getFirstChild().getNodeValue());
        // берем дату записываем в parsed
        NodeList dateNodeList = element.getElementsByTagName(TagsConst.DATE_TAG);
        root.setDate(dateNodeList.item(0).getFirstChild().getNodeValue());
        // создаем лист для элементов массива weather
        ArrayList<Weather> weatherList = new ArrayList<>();

        // разбираем поэлементно каждый элемент массива weather. Берем все теги с именем 'element' и перебираем каждый
        NodeList nList = element.getElementsByTagName(TagsConst.ELEMENT_TAG);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                // отделяем element weather`а от element`а - в файле есть 2 вида данных под тэгом 'element'
                // если очередной тэг "date" в weather`е, значит, начинаем новый элемент
                if (eElement.getElementsByTagName(TagsConst.DATE_TAG).item(0)!=null) {
                    Weather weather = new Weather();

                    //ставим дату
                    weather.setDate(eElement.getElementsByTagName(TagsConst.DATE_TAG).item(0).getTextContent());

                    // не пустое ли поле "description", если да - вписываем пустое знчение,
                    // если нет - вписываем значение
                    Node descriptionNode = eElement.getElementsByTagName(TagsConst.DESCRIPTION_TAG).item(0);
                    if (descriptionNode == null)
                        weather.setDescription("");
                    else
                        weather.setDescription(descriptionNode.getTextContent());

                    // не пустое ли поле "humidity", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node humidityNode = eElement.getElementsByTagName(TagsConst.HUMIDITY_TAG).item(0);
                    if (humidityNode == null)
                        weather.setHumidity(-999);
                    else
                        weather.setHumidity(Integer.parseInt(humidityNode.getTextContent()));

                    // не пустое ли поле "id", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node idNode = eElement.getElementsByTagName(TagsConst.ID_TAG).item(0);
                    if (idNode == null)
                        weather.setId(-999);
                    else
                        weather.setId(Integer.parseInt(idNode.getTextContent()));


                    // создаем и заполняем лист с "location" очередного элемента weather
                    ArrayList<String> locationNodeArray = new ArrayList<>();

                    Node nnNode = eElement.getElementsByTagName(TagsConst.LOCATION_TAG).item(0);
                    if (nnNode == null)
                        locationNodeArray.add("");
                    else {
                        Element eeElement = (Element) nnNode;
                        NodeList nodeListElem = eeElement.getElementsByTagName(TagsConst.ELEMENT_TAG);
                        for (int k=0;k<nodeListElem.getLength();k++)
                            locationNodeArray.add(nodeListElem.item(k).getTextContent());
                    }
                    weather.setLocation(locationNodeArray);


                    // не пустое ли поле "temp_max", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node tempMaxNode = eElement.getElementsByTagName(TagsConst.TEMP_MAX_TAG).item(0);
                    if (tempMaxNode == null)
                        weather.setTempMax(-999);
                    else
                        weather.setTempMax(Integer.parseInt(tempMaxNode.getTextContent()));

                    // не пустое ли поле "temp_min", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node tempMinNode = eElement.getElementsByTagName(TagsConst.TEMP_MIN_TAG).item(0);
                    if (tempMinNode == null)
                        weather.setTempMin(-999);
                    else
                        weather.setTempMin(Integer.parseInt(tempMinNode.getTextContent()));

                    // не пустое ли поле "title", если да - вписываем пустое знчение, если нет - вписываем значение
                    Node titleNode = eElement.getElementsByTagName(TagsConst.TITLE_TAG).item(0);
                    if (titleNode == null)
                        weather.setTitle("");
                    else
                        weather.setTitle(titleNode.getTextContent());

                    // добавляем данный распарсенный элемента массива weather из файла в нашу корзину
                    weatherList.add(weather);
                }
            }
        }
        // добавляем нашу заполненную корзину weather в parsed
        root.setWeather(weatherList);
    }
}

