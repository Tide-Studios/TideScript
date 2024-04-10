package com.tidestudios.util;

import com.tidestudios.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLParser {
    public static Logger logger = new Logger("XMLParser");
    public static void parseID(Document document){
        Element root = document.getRootElement();
        // Finds the packages and their definition in the class and for each of them
        // Kinda a nested for loop but whatever
        for (Iterator<Element> basePackage = root.elementIterator(); basePackage.hasNext();) {

            Element currentPackage = basePackage.next(); // Current package
            ArrayList<String> packageids = new ArrayList<>();
            // Ids of a package
            for(Iterator<Element> packageAttributes = currentPackage.elementIterator("id"); packageAttributes.hasNext();){
                //logger.info(currentPackage.getName() + ":" + packageType.next().attribute("version").getValue());
                String id = packageAttributes.next().getText();
                logger.info("ID"+id);
            }
            for(Iterator<Element> test = currentPackage.elementIterator("version"); test.hasNext();){
                //logger.info(currentPackage.getName() + ":" + packageType.next().attribute("version").getValue());
                String id = test.next().getText();
                logger.info("Version"+id);
            }
            // End of Loop
            }


        }

    public Document parser(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
}
