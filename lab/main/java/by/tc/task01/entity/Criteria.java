package main.java.by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private Map<String, String> params;

	private static final String FIND_IN_APPLIANCE_TYPE = "type";

	public Criteria() {
		params = new HashMap<String, String>();
	}

	public Criteria(String applianceType) {
		params = new HashMap<String, String>();
		params.put(FIND_IN_APPLIANCE_TYPE, applianceType);
	}


}
