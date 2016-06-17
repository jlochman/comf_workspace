package cz.jlochman.comfigo.core.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ProductDAO;
import cz.jlochman.comfigo.core.entityDomain.Image;
import cz.jlochman.comfigo.core.entityDomain.Parameter;
import cz.jlochman.comfigo.core.entityDomain.Product;
import cz.jlochman.comfigo.core.services.ProductService;

public class ProductServiceImpl implements ProductService {

	private Date downloadDate;
	private ProductDAO productDAO = ServiceLocator.getInstance().getDaos()
			.getProductDAO();

	public ProductServiceImpl() {
		downloadDate = new Date();
	}

	public Product parseProductFromHTML(Document htmlPage) {
		Product product = new Product();
		product.setDownloadDate(downloadDate);

		Element productEssential = htmlPage.select("div.product-essential")
				.first();

		product.setName(productEssential.select("div.product-name").first()
				.text());
		System.out.println("product name: " + product.getName());
		product.setDescription(productEssential.select("div.std").first()
				.text());
		System.out.println("product description: " + product.getDescription());
		product.setUrl(htmlPage.baseUri());

		List<Parameter> parameters = new ArrayList<Parameter>();
		Element productTable = productEssential.select("div.padder").first();
		Elements tblRows = productTable.select("tr");
		for (Element row : tblRows) {
			Parameter param = new Parameter();
			param.setName(row.select("th").first().text());
			param.setValue(row.select("td").first().text());
			param.setProduct(product);
			parameters.add(param);
			System.out.println(param.getName() + ": " + param.getValue());
		}
		product.setParameters(parameters);

		List<Image> images = new ArrayList<Image>();
		Element productImages = productEssential.select("div.more-views")
				.first();
		Elements imgLinks = productImages.select("a");
		for (Element element : imgLinks) {
			String imgUrl = element.attr("abs:href");
			Image img = ServiceLocator.getInstance().getImageService()
					.getImageFromURL(imgUrl);
			img.setProduct(product);
			images.add(img);
			System.out.println("image url: " + imgUrl);
		}
		product.setImages(images);

		return product;
	}

	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public List<Date> getAllDownDates() {
		return productDAO.getAllDownDates();
	}

	public Date getLastDownDate() {
		List<Date> dates = getAllDownDates();
		if (dates == null || dates.isEmpty())
			return null;
		return dates.get(dates.size() - 1);
	}

	public List<Product> getProductsForDownDate(Date downDate) {
		return productDAO.getProductsForDownDate(downDate);
	}

}
