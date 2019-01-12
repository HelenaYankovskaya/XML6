package DOMSTAX;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

public class Dom {                //Задание №10 Рт-2 стр 36

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\user\\IdeaProjects\\XML6\\src\\ExampleForParser");
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = Factory.newDocumentBuilder();
            Document doc = Builder.parse(inputFile);
            Element root = doc.getDocumentElement();

            System.out.println("Massiv of points :" + root.getTagName());
            NodeList nList = root.getElementsByTagName("point");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.print(nNode.getNodeName()+ " №"+ temp + ":");
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    System.out.print("  "
                            + element
                            .getElementsByTagName("x")
                            .item(0)
                            .getTextContent());
                    System.out.print(element.getAttribute("unit"));
                    System.out.print(", "
                            + element
                            .getElementsByTagName("y")
                            .item(0)
                            .getTextContent());
                    System.out.println(element.getAttribute("unit"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}