package DOMHomeWork;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class ParseXML {

    public static void main(String[] args) {

        Document dom;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("testXML.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Root r = new Root();

        Element root = dom.getDocumentElement();
        System.out.println("tag 1 = " + root.getTagName());

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = " + nameNode.getNodeName());

        String name = nameNode.getFirstChild().getNodeValue();
        System.out.println("name = " + name);



        NodeList peopleNodeList = root.getElementsByTagName("people");
        Node peopleNode = peopleNodeList.item(0);
        System.out.println("tag 3 = " + peopleNode.getNodeName());

        NodeList elementsNodeList = peopleNode.getChildNodes();

        ArrayList<People> list = new ArrayList<>();

        for (int i = 0; i < elementsNodeList.getLength(); i++) {

            Node node = elementsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            People el = new People();

            System.out.println("======================================");

            Element element = (Element) node;
            System.out.println("tag = " + node.getNodeName());

            // name
            NodeList nameElemlist = element.getElementsByTagName("name");
            Element nameElement = (Element) nameElemlist.item(0);
            String namePeople = nameElement.getFirstChild().getNodeValue();
            System.out.println("name : " + namePeople);

            el.setName(namePeople);

            // surname
            String surnamePeople = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println("surname : " + surnamePeople);

            el.setSurname(surnamePeople);

            // age
            String agePeople = element.getElementsByTagName("age").item(0).getTextContent();
            System.out.println("age : " + agePeople);

            el.setAge(Integer.valueOf(agePeople));

            // age
            String isDegree = element.getElementsByTagName("isDegree").item(0).getTextContent();
            System.out.println("age : " + isDegree);

            el.setDegree(Boolean.valueOf(isDegree));


            list.add(el);
        }

        for(People e: list) {

            System.out.println(e.toString());

        }

    }

}
