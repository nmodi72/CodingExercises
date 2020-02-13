package main.java.Impl.misc;

import javax.lang.model.util.Elements;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by nmodi on 9/26/18.
 */
public class InspectFireTvFile {

    private static final String FILENAME_V1 = "/Users/nmodi/Downloads/v1_1_catalogsyndication.xml";
    private static final String FILENAME_V2 = "/Users/nmodi/Downloads/v1_2_catalogsyndication.xml";
    private static final String FILENAME_V3 = "/Users/nmodi/Downloads/v2_1_catalogsyndication.xml";

    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory factoryV1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builderV1 = factoryV1.newDocumentBuilder();
        Document documentV1 = builderV1.parse(new File(FILENAME_V1));
        Element rootElementV1 = documentV1.getDocumentElement();
        String requestQueueNameV1 = getString("LaunchId", rootElementV1);

        DocumentBuilderFactory factoryV2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builderV2 = factoryV2.newDocumentBuilder();
        Document documentV2 = builderV2.parse(new File(FILENAME_V2));
        Element rootElementV2 = documentV2.getDocumentElement();
        String requestQueueNameV2 = getString("LaunchId", rootElementV2);

        DocumentBuilderFactory factoryV3 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builderV3 = factoryV3.newDocumentBuilder();
        Document documentV3 = builderV3.parse(new File(FILENAME_V3));
        Element rootElementV3 = documentV3.getDocumentElement();
        String requestQueueNameV3 = getString("LaunchId", rootElementV3);

    }

    public static String getString(String tagName, Element element) {
        NodeList nlist = element.getElementsByTagName(tagName);
        if (nlist != null && nlist.getLength() > 0) {
            NodeList children = nlist.item(0).getChildNodes();
            System.out.println(children.item(0).getNodeValue());
//            for (int i = 0; i < nlist.getLength(); i++) {
//                Node node = nlist.item(i);
//                NodeList children = node.getChildNodes();
//                if (children != null && children.getLength() > 0) {
//                    System.out.println(children.item(i).getNodeValue());
//                }
//
//            }

//            NodeList subList = nlist.item(0).getChildNodes();
//            if (subList != null && subList.getLength() > 0) {
//                return subList.item(0).getNodeValue();
//            }
        }

        return null;
    }
}
