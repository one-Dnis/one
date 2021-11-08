package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.entity.Appliance;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;


public class ApplianceRepository {
	private static final ApplianceRepository instance = new ApplianceRepository();

	private List<Appliance> data;
	
	private ApplianceRepository() {
		ApplianceXMLReader reader = new ApplianceXMLReader();
		try {
			data = reader.parse();
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Appliance> getData(){
		return data;
	}
	
	public static ApplianceRepository getInstance() {
		return instance;
	}
}
