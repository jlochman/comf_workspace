package cz.jlochman.comfigo.core.services;

import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;

import cz.jlochman.comfigo.core.entityDomain.Product;

public interface ProductService {

	public Product parseProductFromHTML(Document htmlPage);

	public List<Product> getAllProducts();

	public List<Date> getAllDownDates();

	public Date getLastDownDate();

	public List<Product> getProductsForDownDate(Date downDate);

	public String getNormalizedName(Product product);

}
