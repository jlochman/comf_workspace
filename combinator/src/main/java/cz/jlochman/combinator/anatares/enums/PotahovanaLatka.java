package cz.jlochman.combinator.anatares.enums;

import cz.jlochman.combinator.enitityDomain.Value;

public enum PotahovanaLatka {

	BALI("Bali (B)"),
	BONDAI("Bondai (BN)"),
	Cagliari("Cagliari (C)");
	
	private Value value;
	
	private PotahovanaLatka(String name) {
		value = new Value(name);
	}
	
	public Value getValue() {
		return value;
	}
	
}
