package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.Criteria;

import java.util.List;



public class Searcher {
	
	private ApplianceRepository repository;
	private List<String> searchData;
	
	public Searcher() {
		this.repository = ApplianceRepository.getInstance() ;
		searchData = initSearchData();
	}
	

	public List<Appliance> find(Criteria criteria){
		
		return null;
	}
	
	private List<String> initSearchData() {
		List<Appliance> appliances = repository.getInstance().getData();
		return null;
	}

}
