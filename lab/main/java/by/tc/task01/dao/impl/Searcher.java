package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.entity.Appliance;

import java.util.List;


public class Searcher {

    private ApplianceRepository repository;


    public Searcher() {
        this.repository = ApplianceRepository.getInstance();
    }


    public List<Appliance> find() {
        return repository.getInstance().getData();
    }

}
