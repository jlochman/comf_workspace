package cz.jlochman.combinator.anatares.enums;

import cz.jlochman.combinator.enitityDomain.Value;

public enum Textura {

	B3("B 3"),
	B13("B 13");
	
	private Value value;
	
	private Textura(String name) {
		value = new Value(name);
	}
	
	public Value getValue() {
		return value;
	}
	
}
