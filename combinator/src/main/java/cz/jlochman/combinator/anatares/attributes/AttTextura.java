package cz.jlochman.combinator.anatares.attributes;

import cz.jlochman.combinator.anatares.enums.Textura;
import cz.jlochman.combinator.enitityDomain.Attribute;
import cz.jlochman.combinator.enums.AttributeType;

public class AttTextura extends Attribute {

	public AttTextura() {
		super("Textura - Antares", AttributeType.COLOR);
	}

	@Override
	public void addAllValues() {
		Textura[] array = Textura.values();
		for (int i = 0; i < array.length; i++) {
			addValue(array[i].getValue());
		}
	}

}
