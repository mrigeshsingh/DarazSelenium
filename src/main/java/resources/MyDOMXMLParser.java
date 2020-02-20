package resources;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class MyDOMXMLParser {
    static MyDOMXMLParser parser = new MyDOMXMLParser();
    public static int itr = -1 ;
    public static void main(String[] args) {
        parser.getUsernameOrPassword("username");
    }

    public String getUsernameOrPassword(String usernameOrPassword) {
        String usrOrPwd = null;
        if(usernameOrPassword == "username"){itr = itr + 1;}

        System.out.println(itr);

        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File("src\\main\\java\\resources\\Users.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("user");
            //System.out.println(nodeList.getLength());

            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                usrOrPwd = (eElement.getElementsByTagName(usernameOrPassword).item(0).getTextContent());
                System.out.println(usrOrPwd);

            }

            if (usernameOrPassword == "password"){
                if( itr == nodeList.getLength()-1){
                    itr=-1;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return usrOrPwd;
    }
}  