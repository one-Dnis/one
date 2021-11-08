package main.java.by.tc.task01.dao;

import main.java.by.tc.task01.entity.Appliance;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {
     List<Appliance> find();
     void add(Element newAppliance) throws JDOMException, IOException;
}
