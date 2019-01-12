package DOMSTAX;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.*;

public class StAXPars {                       //Задание №11 Рт-2 стр 37


    public static void main(String[] args) {
        String unit1 = null;
        int i=1;
        boolean isX = false;
        boolean isY = false;
        boolean isPoint = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader =
                    factory.createXMLStreamReader (new FileReader("C:\\Users\\user\\IdeaProjects\\XML6\\src\\ExampleForParser"));


            while(reader.hasNext()) {
                int res = reader.next();
                if (res==reader.START_ELEMENT) {
                        if (reader.getLocalName().equals("point")){
                           unit1 = reader.getAttributeValue(0);
                            isPoint = true;}
                         else if (reader.getLocalName().equals("x"))
                           isX = true;
                         else if (reader.getLocalName().equals("y"))
                            isY = true;
                        }

                       else if(res == reader.CHARACTERS) {
                         if (isPoint) {
                             System.out.println("Point:"+ i);
                             i++;
                           isPoint = false; 
                        }
                        else if(isX) {
                            System.out.print(reader.getText());
                             System.out.print(unit1);
                            isX = false;
                        }
                         else if(isY) {
                             System.out.print(", "+reader.getText());
                             System.out.println(unit1);
                             isY = false;
                         }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}