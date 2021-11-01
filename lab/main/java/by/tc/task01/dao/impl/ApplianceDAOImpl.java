package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.entity.*;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    private Searcher searcher;

    {
        searcher = new Searcher();
    }

    @Override
    public List<Appliance> find(Criteria criteria) {

        return searcher.find(criteria);
    }
}