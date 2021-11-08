package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.entity.*;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    private Searcher searcher;
    private ApplianceXMLWriter applianceXMLWriter;

    {
        searcher = new Searcher();
        applianceXMLWriter = new ApplianceXMLWriter();
    }

    @Override
    public List<Appliance> find() {

        return searcher.find();
    }

    @Override
    public void add(Element newAppliance) throws JDOMException, IOException {
        applianceXMLWriter.addAppliance(newAppliance);
    }
}