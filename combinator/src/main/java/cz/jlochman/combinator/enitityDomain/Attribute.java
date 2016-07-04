package cz.jlochman.combinator.enitityDomain;

import java.util.ArrayList;
import java.util.List;

import cz.jlochman.combinator.enums.AttributeType;

public abstract class Attribute {
	
	private String name;
	private AttributeType type;
	private Attribute prevAttribute;
	
	private List<Value> values;
	private int index;
	
	public Attribute(String name, AttributeType type) {
		this.name = name;
		this.type = type;
		values = new ArrayList<Value>();
		index = 0;
	}
	
	public void addValue(Value value) {
		values.add(value);
	}
	
	public void addValues(Value... values) {
		for (int i = 0; i < values.length; i++) {
			addValue(values[i]);
		}
	}
	
	public void clearValues() {
		values.clear();
	}
	
	public abstract void addAllValues();
	
	public boolean nextValue() {
		if (this.increment()) {
			return true;
		} else {
			if (prevAttribute != null) {
				return prevAttribute.nextValue();
			} else {
				return false;
			}
		}
	}

	private boolean increment() {
		index++;
		if (index >= values.size()) {
			index = 0;
			return false;
		}
		return true;
	}
	
	public void setPrevAttribute(Attribute prevAttribute) {
		this.prevAttribute = prevAttribute;
	}
	
	public void setType(AttributeType type) {
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public AttributeType getType() {
		return type;
	}
	
	public Value getValue() {
		return values.get(index);
	}
	
}
