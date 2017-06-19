package SAXHomeWork;


import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.util.ArrayList;


public class ParseXML_SAX extends DefaultHandler {

    public static void main(String[] args) {

        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            ParseXML_SAX handler = new ParseXML_SAX();
            xr.setContentHandler(handler);
            xr.setErrorHandler(handler);

            FileReader r = new FileReader("testXML.xml");
            xr.parse(new InputSource(r));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }


    Root_SAX root = new Root_SAX();

    ArrayList<String> listOfTags = new ArrayList<>();
    ArrayList<People_SAX> listOfPeople = new ArrayList<>();
    private People_SAX el;


    private void newTags(String qName) {

        if (listOfTags.size() < 3) {
            if (listOfTags.size() == 0) {
                System.out.println("tag 1 = " + qName);
                root.setName(qName);
            } else if (listOfTags.size() == 1)
                System.out.println("tag 2 = " + qName);
            else if (listOfTags.size() == 2)
                System.out.println("tag 3 = " + qName);
        } else if (qName.equals("element")) {
            System.out.println("======================================");
            System.out.println("tag = " + qName);
            el = new People_SAX();
        }

        listOfTags.add(qName);

    }


    private void newNamesX(String str) {
        if (listOfTags.size() == 2)
            System.out.println("name = " + str);
        else {

            if (listOfTags.get(listOfTags.size() - 1).equals("name")) {
                System.out.println("name : " + str);
                el.setName(str);
            } else if (listOfTags.get(listOfTags.size() - 1).equals("surname")) {
                System.out.println("surname : " + str);
                el.setSurname(str);
            } else if (listOfTags.get(listOfTags.size() - 1).equals("age")) {
                System.out.println("age : " + str);
                el.setAge(Integer.parseInt(str));
            } else if (listOfTags.get(listOfTags.size() - 1).equals("isDegree")) {
                System.out.println("age : " + str);
                el.setDegree(Boolean.parseBoolean(str));
                listOfPeople.add(el);
            }
        }
    }


    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) throws SAXException {
        newTags(qName);
    }



    @Override
    public void characters(char ch[], int start, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + length; i++) {
            if (ch[i] != '\\' && ch[i] != '"' && ch[i] != '\n' && ch[i] != '\r' && ch[i] != '\t')
                sb.append(ch[i]);
        }
        String str = sb.toString();
        str = str.replaceAll("  ", "");
        if (str.length() == 1 && str.equals(" "))
            str = str.replaceAll(" ", "");
        if (str.length() != 0)
            newNamesX(str);
    }


    @Override
    public void endDocument() throws SAXException {
        root.setPeople(listOfPeople);
        System.out.println("//////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////////");
        for (People_SAX aListOfPeople : listOfPeople) {
            System.out.println(aListOfPeople.toString());
        }
    }
}
