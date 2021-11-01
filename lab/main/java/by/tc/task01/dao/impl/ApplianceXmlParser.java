package main.java.by.tc.task01.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.by.tc.task01.entity.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ApplianceXmlParser {

	private static final String XML_SOURCE_PATH = "src/main/resources/appliances_db.xml";


	public List<Appliance> parse() throws JDOMException, IOException {

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(XML_SOURCE_PATH);
		Document document = builder.build(xmlFile);
		Element appliancesElement = document.getRootElement();


		List<Appliance> appliancesList = new ArrayList<>();


		List<Element> ovensList = appliancesElement.getChildren("oven");

		for (Element element : ovensList) {

			Oven oven = new Oven();

			oven.setType(element.getChildText("type"));
			oven.setPrice(Double.parseDouble(element.getChildText("price")));
			oven.setPowerConsumption(Double.parseDouble(element.getChildText("power-consumption")));
			oven.setWeight(Double.parseDouble(element.getChildText("weight")));
			oven.setCapacity(Double.parseDouble(element.getChildText("capacity")));
			oven.setDepth(Double.parseDouble(element.getChildText("depth")));
			oven.setHeight(Double.parseDouble(element.getChildText("height")));
			oven.setWidth(Double.parseDouble(element.getChildText("width")));

			appliancesList.add(oven);

		}

		List<Element> laptopsList = appliancesElement.getChildren("laptop");

		for (Element element : laptopsList) {

			Laptop laptop = new Laptop();

			laptop.setType(element.getChildText("type"));
			laptop.setPrice(Double.parseDouble(element.getChildText("price")));
			laptop.setBatteryCapacity(Double.parseDouble(element.getChildText("battery-capacity")));
			laptop.setOS(element.getChildText("os"));
			laptop.setMemoryRom(Double.parseDouble(element.getChildText("memory-rom")));
			laptop.setSystemMemory(Double.parseDouble(element.getChildText("system-memory")));
			laptop.setCPU(Double.parseDouble(element.getChildText("cpu")));
			laptop.setDisplayInchs(Double.parseDouble(element.getChildText("display-inchs")));

			appliancesList.add(laptop);
		}

		List<Element> refrigeratorsList = appliancesElement.getChildren("refrigerator");

		for (Element element : refrigeratorsList) {

			Refrigerator refrigerator = new Refrigerator();

			refrigerator.setType(element.getChildText("type"));
			refrigerator.setPrice(Double.parseDouble(element.getChildText("price")));
			refrigerator.setPowerConsumption(Double.parseDouble(element.getChildText("power-consumption")));
			refrigerator.setWeight(Double.parseDouble(element.getChildText("weight")));
			refrigerator.setFreezerCapacity(Double.parseDouble(element.getChildText("freezer-capacity")));
			refrigerator.setOverallCapacity(Double.parseDouble(element.getChildText("overall-capacity")));
			refrigerator.setHeight(Double.parseDouble(element.getChildText("height")));
			refrigerator.setWidth(Double.parseDouble(element.getChildText("width")));

			appliancesList.add(refrigerator);
		}

		List<Element> vacuumCleanersList = appliancesElement.getChildren("vacuum-cleaner");

		for (Element element : vacuumCleanersList) {

			VacuumCleaner vacuumCleaner = new VacuumCleaner();

			vacuumCleaner.setType(element.getChildText("type"));
			vacuumCleaner.setPrice(Double.parseDouble(element.getChildText("price")));
			vacuumCleaner.setPowerConsumption(Double.parseDouble(element.getChildText("power-consumption")));
			vacuumCleaner.setFilterType(element.getChildText("filter-type"));
			vacuumCleaner.setBagType(element.getChildText("bag-type"));
			vacuumCleaner.setWandType(element.getChildText("wand-type"));
			vacuumCleaner.setMotorSpeedRegulation(Double.parseDouble(element.getChildText("motor-speed-regulation")));
			vacuumCleaner.setCleaningWidth(Double.parseDouble(element.getChildText("cleaning-width")));

			appliancesList.add(vacuumCleaner);
		}

		List<Element> tabletPCList = appliancesElement.getChildren("tablet-pc");

		for (Element element : tabletPCList) {

			TabletPC tabletPC = new TabletPC();

			tabletPC.setType(element.getChildText("type"));
			tabletPC.setPrice(Double.parseDouble(element.getChildText("price")));
			tabletPC.setBatteryCapacity(Double.parseDouble(element.getChildText("battery-capacity")));
			tabletPC.setDisplayInchs(Double.parseDouble(element.getChildText("display-inchs")));
			tabletPC.setMemoryRom(Double.parseDouble(element.getChildText("memory-rom")));
			tabletPC.setFlashMemoryCapacity(Double.parseDouble(element.getChildText("flash-memory-capacity")));
			tabletPC.setColor(element.getChildText("color"));

			appliancesList.add(tabletPC);
		}

		List<Element> speakersList = appliancesElement.getChildren("speakers");

		for (Element element : speakersList) {

			Speakers speakers = new Speakers();

			speakers.setType(element.getChildText("type"));
			speakers.setPrice(Double.parseDouble(element.getChildText("price")));
			speakers.setPowerConsumption(Double.parseDouble(element.getChildText("power-consumption")));
			speakers.setNumberOfSpeakers(Integer.parseInt(element.getChildText("number-of-speakers")));
			speakers.setFrequencyRange(element.getChildText("frequency-range"));
			speakers.setCordLength(Double.parseDouble(element.getChildText("cord-length")));

			appliancesList.add(speakers);
		}

		return appliancesList;
	}
}
