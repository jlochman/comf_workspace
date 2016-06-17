package cz.jlochman.comfigo;

import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.entityDomain.Product;

public class App {
	
	private static ServiceLocator serviceLocator = ServiceLocator.getInstance();
	
	public static void main(String[] args) {

		System.out.println("DONE");
	}
	
	private static void download() {
		List<String> urls = serviceLocator.getUrlService().getProductURLs();
		System.out.println("#URL found: "+urls.size());
		
		for (String url : urls) {
			System.out.println("____________________________________________");
			System.out.println("Downloading url... "+url);
			Document htmlPage = serviceLocator.getUrlService().getHtmlPageFromURL(url);
			
			System.out.println("Parsing");
			Product product = serviceLocator.getProductService().parseProductFromHTML(htmlPage);
			product.save();
		}		
	}
	
}
