package com.tidestudios.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class XMLParser {
    public static void parseID(Document document){
        Element root = document.getRootElement();
        for (Iterator<Element> basePackage = root.elementIterator(); basePackage.hasNext();) {
            Element currentPackage = basePackage.next();

            for(Iterator<Element> id = currentPackage.elementIterator(); id.hasNext();){


            }

        }
    }
    public Document parser(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
}
