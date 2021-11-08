package main.java.by.tc.task01.dao.impl;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import java.io.FileOutputStream;
import java.io.IOException;


public class ApplianceXMLWriter {

    private static final String XML_SOURCE_PATH = "src/main/resources/appliances_db.xml"; //пока не нашёл решение

    public void addAppliance(Element newElement) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(XML_SOURCE_PATH);
        Element rootElement = document.getRootElement();

        rootElement.addContent(1, newElement);

        XMLOutputter out = new XMLOutputter();
        out.output(document, new FileOutputStream(XML_SOURCE_PATH));

    }

}