package cz.jlochman.comfigo;

import java.util.List;

import org.jsoup.nodes.Document;

import cz.jlochman.comfigo.core.ServiceLocator;

public class App {
	
	public static void main(String[] args) {
		ServiceLocator serviceLocator = ServiceLocator.getInstance();
		
		List<String> urls = serviceLocator.getUrlService().getProductURLs();
		
		for (String url : urls) {
			System.out.println(url);
			Document htmlPage = serviceLocator.getUrlService().getHtmlPageFromURL(url);
			//System.out.println(htmlPage);
		}
		
		
		System.out.println("DONE");
	}
	
}
