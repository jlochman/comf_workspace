package cz.jlochman.combinator.enums;

public enum AttributeType {

	SELECT("select"),
	COLOR("color");
	
	String type;
	
	private AttributeType(String type) {
		this.type = type;
	}
	
	public String getString() {
		return type;
	}
	
}
