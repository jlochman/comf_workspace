package cz.jlochman.comfigo.core.DAO;

import java.util.Date;
import java.util.List;

import cz.jlochman.comfigo.core.entityDomain.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();

	public List<Date> getAllDownDates();
	
	public List<Product> getProductsForDownDate(Date downDate);
	
}
