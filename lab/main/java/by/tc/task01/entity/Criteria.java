package main.java.by.tc.task01.entity;


public class Criteria {

	private String type;
	private String parameter;
	private String value;


	public Criteria(String type, String parameter, String value) {
		this.type = type;
		this.parameter = parameter;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String getParameter() {
		return parameter;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Criteria criteria = (Criteria) o;

		if (!type.equals(criteria.type)) return false;
		if (!parameter.equals(criteria.parameter)) return false;
		return value.equals(criteria.value);
	}

	@Override
	public int hashCode() {
		int result = type.hashCode();
		result = 31 * result + parameter.hashCode();
		result = 31 * result + value.hashCode();
		return result;
	}
}
