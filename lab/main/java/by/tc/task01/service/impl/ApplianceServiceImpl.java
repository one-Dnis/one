package main.java.by.tc.task01.service.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.dao.impl.ApplianceDAOImpl;
import main.java.by.tc.task01.entity.*;
import main.java.by.tc.task01.service.ApplianceService;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    private ApplianceDAO applianceDAO;

    {
        applianceDAO = new ApplianceDAOImpl();
    }

    @Override
    public void find(Criteria criteria) {
        List<Appliance> appliances = applianceDAO.find();

        for (Appliance app : appliances) {

            if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("oven")) {
                findOven(app, criteria);
            } else if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("laptop")) {
                findLaptop(app, criteria);
            } else if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("refrigerator")) {
                findRefrigerator(app, criteria);
            } else if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("vacuumCleaner")) {
                findVacuumCleaner(app, criteria);
            } else if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("tabletPC")) {
                findTabletPC(app, criteria);
            } else if (criteria.getType().equalsIgnoreCase(app.getType()) & criteria.getType().equalsIgnoreCase("speakers")) {
                findSpeakers(app, criteria);
            }
        }
    }


    private void findOven(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("powerConsumption")) { //тип параметра
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getPowerConsumption()))) { //значение параметра
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("weight")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getWeight()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("capacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("depth")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getDepth()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("height")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getHeight()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("width")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Oven) app).getWidth()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }

    private void findLaptop(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("batteryCapacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Laptop) app).getBatteryCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("os")) {
            if (criteria.getValue().equalsIgnoreCase(((Laptop) app).getOS())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("memoryRom")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Laptop) app).getMemoryRom()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("systemMemory")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Laptop) app).getSystemMemory()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("cpu")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Laptop) app).getCPU()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("displayInchs")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Laptop) app).getDisplayInchs()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }

    private void findRefrigerator(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("powerConsumption")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getPowerConsumption()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("weight")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getWeight()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("freezerCapacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getFreezerCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("overallCapacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getOverallCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("height")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getHeight()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("width")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Refrigerator) app).getWidth()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }

    private void findVacuumCleaner(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("powerConsumption")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((VacuumCleaner) app).getPowerConsumption()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("filterType")) {
            if (criteria.getValue().equalsIgnoreCase(((VacuumCleaner) app).getFilterType())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("bagType")) {
            if (criteria.getValue().equalsIgnoreCase(((VacuumCleaner) app).getBagType())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("wandType")) {
            if (criteria.getValue().equalsIgnoreCase(((VacuumCleaner) app).getWandType())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("motorSpeedRegulation")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((VacuumCleaner) app).getMotorSpeedRegulation()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("cleaningWidth")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((VacuumCleaner) app).getCleaningWidth()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }

    private void findTabletPC(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("batteryCapacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((TabletPC) app).getBatteryCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("displayInchs")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((TabletPC) app).getDisplayInchs()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("memoryRom")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((TabletPC) app).getMemoryRom()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("flashMemoryCapacity")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((TabletPC) app).getFlashMemoryCapacity()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("color")) {
            if (criteria.getValue().equalsIgnoreCase(((TabletPC) app).getColor())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }

    private void findSpeakers(Appliance app, Criteria criteria) {
        if (criteria.getParameter().equalsIgnoreCase("powerConsumption")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Speakers) app).getPowerConsumption()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("numberOfSpeakers")) {
            if (criteria.getValue().equalsIgnoreCase(Integer.toString(((Speakers) app).getNumberOfSpeakers()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("frequencyRange")) {
            if (criteria.getValue().equalsIgnoreCase(((Speakers) app).getFrequencyRange())) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        } else if (criteria.getParameter().equalsIgnoreCase("cordLength")) {
            if (criteria.getValue().equalsIgnoreCase(Double.toString(((Speakers) app).getCordLength()))) {
                System.out.println("есть такой прибор");
                System.out.println(app);
            }
        }
    }


    @Override
    public void add(Appliance appliance) throws JDOMException, IOException {


        if (appliance.getType().equalsIgnoreCase("oven")) {

            Oven newOven = (Oven) appliance;

            Element appliancesElement = new Element("oven");

            appliancesElement.addContent((new Element("type").setText(newOven.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newOven.getPrice())));
            appliancesElement.addContent((new Element("power-consumption").setText("" + newOven.getPowerConsumption())));
            appliancesElement.addContent((new Element("weight").setText("" + newOven.getWeight())));
            appliancesElement.addContent((new Element("capacity").setText("" + newOven.getCapacity())));
            appliancesElement.addContent((new Element("depth").setText("" + newOven.getDepth())));
            appliancesElement.addContent((new Element("height").setText("" + newOven.getHeight())));
            appliancesElement.addContent((new Element("width").setText("" + newOven.getWidth())));

            applianceDAO.add(appliancesElement);

        } else if (appliance.getType().equalsIgnoreCase("laptop")) {

            Laptop newLaptop = (Laptop) appliance;

            Element appliancesElement = new Element("laptop");

            appliancesElement.addContent((new Element("type").setText(newLaptop.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newLaptop.getPrice())));
            appliancesElement.addContent((new Element("battery-capacity").setText("" + newLaptop.getBatteryCapacity())));
            appliancesElement.addContent((new Element("os").setText(newLaptop.getOS())));
            appliancesElement.addContent((new Element("memory-rom").setText("" + newLaptop.getMemoryRom())));
            appliancesElement.addContent((new Element("system-memory").setText("" + newLaptop.getSystemMemory())));
            appliancesElement.addContent((new Element("cpu").setText("" + newLaptop.getCPU())));
            appliancesElement.addContent((new Element("display-inchs").setText("" + newLaptop.getDisplayInchs())));

            applianceDAO.add(appliancesElement);

        } else if (appliance.getType().equalsIgnoreCase("refrigerator")) {

            Refrigerator newRefrigerator = (Refrigerator) appliance;

            Element appliancesElement = new Element("Refrigerator");

            appliancesElement.addContent((new Element("type").setText(newRefrigerator.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newRefrigerator.getPrice())));
            appliancesElement.addContent((new Element("power-consumption").setText("" + newRefrigerator.getPowerConsumption())));
            appliancesElement.addContent((new Element("weight").setText("" + newRefrigerator.getWeight())));
            appliancesElement.addContent((new Element("freezer-capacity").setText("" + newRefrigerator.getFreezerCapacity())));
            appliancesElement.addContent((new Element("overall-capacity").setText("" + newRefrigerator.getOverallCapacity())));
            appliancesElement.addContent((new Element("height").setText("" + newRefrigerator.getHeight())));
            appliancesElement.addContent((new Element("width").setText("" + newRefrigerator.getWidth())));

            applianceDAO.add(appliancesElement);

        } else if (appliance.getType().equalsIgnoreCase("vacuumCleaner")) {

            VacuumCleaner newVacuumCleaner = (VacuumCleaner) appliance;

            Element appliancesElement = new Element("refrigerator");

            appliancesElement.addContent((new Element("type").setText(newVacuumCleaner.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newVacuumCleaner.getPrice())));
            appliancesElement.addContent((new Element("power-consumption").setText("" + newVacuumCleaner.getPowerConsumption())));
            appliancesElement.addContent((new Element("filter-type").setText(newVacuumCleaner.getFilterType())));
            appliancesElement.addContent((new Element("bag-type").setText(newVacuumCleaner.getBagType())));
            appliancesElement.addContent((new Element("wand-type").setText(newVacuumCleaner.getWandType())));
            appliancesElement.addContent((new Element("motor-speed-regulation").setText("" + newVacuumCleaner.getMotorSpeedRegulation())));
            appliancesElement.addContent((new Element("cleaning-width").setText("" + newVacuumCleaner.getCleaningWidth())));

            applianceDAO.add(appliancesElement);

        } else if (appliance.getType().equalsIgnoreCase("tabletPC")) {

            TabletPC newTabletPC = (TabletPC) appliance;

            Element appliancesElement = new Element("Tablet-pc");

            appliancesElement.addContent((new Element("type").setText(newTabletPC.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newTabletPC.getPrice())));
            appliancesElement.addContent((new Element("battery-capacity").setText("" + newTabletPC.getBatteryCapacity())));
            appliancesElement.addContent((new Element("display-inchs").setText("" + newTabletPC.getDisplayInchs())));
            appliancesElement.addContent((new Element("memory-rom").setText("" + newTabletPC.getMemoryRom())));
            appliancesElement.addContent((new Element("flash-memory-capacity").setText("" + newTabletPC.getFlashMemoryCapacity())));
            appliancesElement.addContent((new Element("color").setText(newTabletPC.getColor())));

            applianceDAO.add(appliancesElement);
        } else if (appliance.getType().equalsIgnoreCase("speakers")) {

            Speakers newSpeakers = (Speakers) appliance;

            Element appliancesElement = new Element("Speakers");

            appliancesElement.addContent((new Element("type").setText(newSpeakers.getType())));
            appliancesElement.addContent((new Element("price").setText("" + newSpeakers.getPrice())));
            appliancesElement.addContent((new Element("power-consumption").setText("" + newSpeakers.getPowerConsumption())));
            appliancesElement.addContent((new Element("number-of-speakers").setText("" + newSpeakers.getNumberOfSpeakers())));
            appliancesElement.addContent((new Element("frequency-range").setText(newSpeakers.getFrequencyRange())));
            appliancesElement.addContent((new Element("cord-length").setText("" + newSpeakers.getCordLength())));

            applianceDAO.add(appliancesElement);
        }

    }
}

//чукча писатель
