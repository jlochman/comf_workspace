package cz.jlochman.combinator.enitityDomain;

public class Value {

	private String name;
	private int priceImpact;
	
	public Value(String name) {
		this(name, 0);
	}
	
	public Value(String name, int priceImpact) {
		this.name = name;
		this.priceImpact = priceImpact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceImpact() {
		return priceImpact;
	}

	public void setPriceImpact(int priceImpact) {
		this.priceImpact = priceImpact;
	}

}
