package ppj09.gwt.swapweb.client.datatype;

public class Parameter {
	private String name;
	private Object value;
	private int operator;
	
	public Parameter(String name, int operator, Object value) {
		this.name = name;
		this.value = value;
		this.operator = operator;
	}
}
