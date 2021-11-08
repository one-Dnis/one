package main.java.by.tc.task01.service;

import main.java.by.tc.task01.entity.Appliance;


import main.java.by.tc.task01.entity.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;

public interface ApplianceService {
    void find(Criteria criteria);
    void add(Appliance appliance) throws JDOMException, IOException;

}
