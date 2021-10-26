package main.java.by.tc.task01.main;

import main.java.by.tc.task01.dao.JDOMParser;
import main.java.by.tc.task01.entity.Appliance;
import org.jdom2.JDOMException;

import java.io.IOException;

public class PrintApplianceInfo {

	public void printApp(String type) throws JDOMException, IOException {
		JDOMParser jd = new JDOMParser();
		jd.printCatalog(type);

	}

	// you may add your own code here

}
