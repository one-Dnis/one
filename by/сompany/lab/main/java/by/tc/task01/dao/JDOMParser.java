package main.java.by.tc.task01.dao;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JDOMParser {

    static String fileName = "C:\\Users\\Dnis\\IdeaProjects\\FirstWebLab\\src\\main\\resources\\appliances_db";


    private Element getXMLFile() throws JDOMException, IOException {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(fileName);
        Document document = builder.build(xmlFile);
        Element appliancesElement = document.getRootElement();

        //System.out.println("Parsing FILE: "+ xmlFile.getAbsolutePath());
        return appliancesElement;
    }

    private void getOvensList(Element appliancesElement) {

        Element ovensElement = appliancesElement.getChild("ovens");
        List<Element> ovenslist = ovensElement.getChildren("oven");

        for (int i = 0; i < ovenslist.size(); i++) {

            Element element = ovenslist.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("power-consumption : " + element.getChildText("power-consumption"));

            System.out.println("weight : " + element.getChildText("weight"));

            System.out.println("capacity : " + element.getChildText("capacity"));

            System.out.println("depth : " + element.getChildText("depth"));

            System.out.println("height : " + element.getChildText("height"));

            System.out.println("width : " + element.getChildText("width"));

        }
    }

    private void getLaptopsList(Element appliancesElement) {

        Element laptopElement = appliancesElement.getChild("laptops");
        List<Element> laptopslist = laptopElement.getChildren("laptop");

        for (int i = 0; i < laptopslist.size(); i++) {

            Element element = laptopslist.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("battery-capacity : " + element.getChildText("battery-capacity"));

            System.out.println("os : " + element.getChildText("os"));

            System.out.println("memory-rom : " + element.getChildText("memory-rom"));

            System.out.println("system-memory : " + element.getChildText("system-memory"));

            System.out.println("cpu : " + element.getChildText("cpu"));

            System.out.println("display-inchs : " + element.getChildText("display-inchs"));

        }
    }

    private void getRefrigeratorsList(Element appliancesElement) {

        Element refrigeratorsElement = appliancesElement.getChild("refrigerators");
        List<Element> refrigeratorsList = refrigeratorsElement.getChildren("refrigerator");

        for (int i = 0; i < refrigeratorsList.size(); i++) {

            Element element = refrigeratorsList.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("power-consumption : " + element.getChildText("power-consumption"));

            System.out.println("weight : " + element.getChildText("weight"));

            System.out.println("freezer-capacity : " + element.getChildText("freezer-capacity"));

            System.out.println("overall-capacity : " + element.getChildText("overall-capacity"));

            System.out.println("height : " + element.getChildText("height"));

            System.out.println("width : " + element.getChildText("width"));

        }
    }

    private void getVacuumCleanersList(Element appliancesElement) {

        Element vacuumCleanersElement = appliancesElement.getChild("vacuum-cleaners");
        List<Element> vacuumCleanerslist = vacuumCleanersElement.getChildren("vacuum-cleaner");

        for (int i = 0; i < vacuumCleanerslist.size(); i++) {

            Element element = vacuumCleanerslist.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("power-consumption : " + element.getChildText("power-consumption"));

            System.out.println("filter-type : " + element.getChildText("filter-type"));

            System.out.println("bag-type : " + element.getChildText("bag-type"));

            System.out.println("wand-type : " + element.getChildText("wand-type"));

            System.out.println("motor-speed-regulation : " + element.getChildText("motor-speed-regulation"));

            System.out.println("cleaning-width : " + element.getChildText("cleaning-width"));

        }
    }

    private void getTabletPCList(Element appliancesElement) {

        Element tabletPCElement = appliancesElement.getChild("tablet-pcs");
        List<Element> tabletPCList = tabletPCElement.getChildren("tablet-pc");

        for (int i = 0; i < tabletPCList.size(); i++) {

            Element element = tabletPCList.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("battery-capacity : " + element.getChildText("battery-capacity"));

            System.out.println("display-inchs : " + element.getChildText("display-inchs"));

            System.out.println("memory-rom : " + element.getChildText("memory-rom"));

            System.out.println("flash-memory-capacity : " + element.getChildText("flash-memory-capacity"));

            System.out.println("motor-speed-regulation : " + element.getChildText("motor-speed-regulation"));

            System.out.println("color : " + element.getChildText("color"));

        }
    }

    private void getSpeakersList(Element appliancesElement) {

        Element speakersElement = appliancesElement.getChild("loudspeakers");
        List<Element> speakerslist = speakersElement.getChildren("speakers");

        for (int i = 0; i < speakerslist.size(); i++) {

            Element element = speakerslist.get(i);

            System.out.println(" ------ ");

            System.out.println("type : " + element.getChildText("type"));

            System.out.println("power-consumption : " + element.getChildText("power-consumption"));

            System.out.println("number-of-speakers : " + element.getChildText("number-of-speakers"));

            System.out.println("frequency-range : " + element.getChildText("frequency-range"));

            System.out.println("cord-length : " + element.getChildText("cord-length"));

        }
    }


    public void printCatalog(String type) throws JDOMException, IOException {
        if (type.equalsIgnoreCase("ovens")) {
            getOvensList(getXMLFile());
        } else if (type.equalsIgnoreCase("laptops")) {
            getLaptopsList(getXMLFile());
        } else if (type.equalsIgnoreCase("refrigerators")) {
            getRefrigeratorsList(getXMLFile());
        } else if (type.equalsIgnoreCase("vacuum-cleaner")) {
            getVacuumCleanersList(getXMLFile());
        } else if (type.equalsIgnoreCase("tablet-pcs")) {
            getTabletPCList(getXMLFile());
        } else if (type.equalsIgnoreCase("speakers")) {
            getSpeakersList(getXMLFile());
        } else if (type.equalsIgnoreCase("all")) {
            getOvensList(getXMLFile());
            getLaptopsList(getXMLFile());
            getRefrigeratorsList(getXMLFile());
            getVacuumCleanersList(getXMLFile());
            getTabletPCList(getXMLFile());
            getSpeakersList(getXMLFile());
        }
    }
}



