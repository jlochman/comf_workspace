package cz.jlochman.comfigo.core.services;

import java.util.List;

import org.jsoup.nodes.Document;

public interface UrlService {

	public List<String> getProductURLs();

	public Document getHtmlPageFromURL(String url);

}
