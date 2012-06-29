/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsclient;

/**
 *
 * @author Vinicius
 */

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

 

public class XMLParser {
       
    public String getResult() throws SAXException, IOException
    {
        try {
            File fXmlFile = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            Element GlobalTag = doc.getDocumentElement();

            return "\nCountry : " + getTagValue("Name", GlobalTag)
            + "\nCountry code : " + getTagValue("CountryCode", GlobalTag)
            + "\nCurrency : " + getTagValue("Currency", GlobalTag)
            + "\nCurrencyCode : " + getTagValue("CurrencyCode", GlobalTag)
            + "\nDDI : " + getTagValue("code", GlobalTag)
            + "\n\nLocation : " + getTagValue("Location", GlobalTag)
            + "\nTime : " + getTagValue("Time", GlobalTag)
            + "\nGMT : " + getTagValue("GMT", GlobalTag)
            + "\nVisibility : " + getTagValue("Visibility", GlobalTag) 
            + "\nTemperature : " + getTagValue("Temperature", GlobalTag) 
            + "\nDewPoint : " + getTagValue("DewPoint", GlobalTag) 
            + "\nRelativeHumidity : " + getTagValue("RelativeHumidity", GlobalTag) 
            + "\nStatus : " + getTagValue("Status", GlobalTag);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            try {                
                File fXmlFile = new File("data.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                //NodeList nList = doc.getElementsByTagName("CurrentWeather");
                Element GlobalTag = doc.getDocumentElement();

                return "\nCountry : " + getTagValue("Name", GlobalTag)
                + "\nCountry code : " + getTagValue("CountryCode", GlobalTag)
                + "\nCurrency : " + getTagValue("Currency", GlobalTag)
                + "\nCurrencyCode : " + getTagValue("CurrencyCode", GlobalTag)
                + "\nDDI : " + getTagValue("code", GlobalTag)
                + "\nGMT : " + getTagValue("GMT", GlobalTag);
                //e.printStackTrace();
            } catch (ParserConfigurationException ex) {
                System.out.println("erro");
            }
        }       
        return "";
    }
    
 
    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }
   
   

}
