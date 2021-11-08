package main.java.by.tc.task01.main;



import main.java.by.tc.task01.entity.Criteria;

import main.java.by.tc.task01.entity.Laptop;
import main.java.by.tc.task01.entity.Oven;
import main.java.by.tc.task01.service.ApplianceService;
import main.java.by.tc.task01.service.impl.ApplianceServiceImpl;
import org.jdom2.JDOMException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws JDOMException, IOException {

        //добавить в xml

        Oven newOven = new Oven("oven", 22, 22, 22, 22, 22, 22, 22);
        Laptop newLaptop = new Laptop("laptop", 1111, 11, "windows", 11, 11, 11, 11);

        ApplianceService applianceService = new ApplianceServiceImpl();
        applianceService.add(newLaptop);
        applianceService.add(newOven);


        //найти в xml

        Criteria criteria1 = new Criteria("oven", "powerConsumption", "1000.0");
        Criteria criteria2 = new Criteria("laptop", "os", "windows");
        ApplianceService findApplianceService = new ApplianceServiceImpl();
        findApplianceService.find(criteria1);
        findApplianceService.find(criteria2);















    }
}
