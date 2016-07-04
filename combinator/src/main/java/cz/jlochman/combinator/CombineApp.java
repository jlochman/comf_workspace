package cz.jlochman.combinator;

import java.util.ArrayList;
import java.util.List;

import cz.jlochman.combinator.anatares.attributes.AttPotahovanaLatka;
import cz.jlochman.combinator.anatares.attributes.AttTextura;
import cz.jlochman.combinator.enitityDomain.Attribute;

public class CombineApp {

	public static void main(String[] args) {

		Attribute potahovanaLatka = new AttPotahovanaLatka();
		potahovanaLatka.addAllValues();

		Attribute textura = new AttTextura();
		textura.addAllValues();
		textura.setPrevAttribute(potahovanaLatka);

		List<Attribute> list = new ArrayList<Attribute>();
		list.add(potahovanaLatka);
		list.add(textura);

		print(list);
		while (textura.nextValue()) {
			print(list);
		}

	}

	private static void print(List<Attribute> list) {
		int counter;
		String result = "\"1\";\"";

		counter = 0;
		for (Attribute attribute : list) {
			result += attribute.getName();
			result += ":";
			result += attribute.getType().getString();
			result += ":";
			result += counter;
			result += ",";
			counter++;
		}
		result = removeLastChar(result);
		result += "\";\"";

		counter = 0;
		for (Attribute attribute : list) {
			result += attribute.getValue().getName();
			result += ":";
			result += counter;
			result += ",";
			counter++;
		}
		result = removeLastChar(result);
		result += "\";\"";

		System.out.println(result);

	}

	private static String removeLastChar(String str) {
		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

}
