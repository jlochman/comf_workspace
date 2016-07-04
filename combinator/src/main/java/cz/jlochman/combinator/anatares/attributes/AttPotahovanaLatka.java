package cz.jlochman.combinator.anatares.attributes;

import cz.jlochman.combinator.anatares.enums.PotahovanaLatka;
import cz.jlochman.combinator.enitityDomain.Attribute;
import cz.jlochman.combinator.enums.AttributeType;

public class AttPotahovanaLatka extends Attribute {

	public AttPotahovanaLatka() {
		super("Potahovaná látka - Antares", AttributeType.SELECT);
	}

	@Override
	public void addAllValues() {
		PotahovanaLatka[] array = PotahovanaLatka.values();
		for (int i = 0; i < array.length; i++) {
			addValue(array[i].getValue());
		}
	}

}
