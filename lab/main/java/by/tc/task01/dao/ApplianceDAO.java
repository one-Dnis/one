package main.java.by.tc.task01.dao;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {
     List<Appliance> find(Criteria criteria);
     //boolean add(Appliance newAppliance);
}
