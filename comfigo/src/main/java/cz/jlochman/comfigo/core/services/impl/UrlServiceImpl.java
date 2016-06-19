package cz.jlochman.comfigo.core.services.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cz.jlochman.comfigo.core.services.UrlService;

public class UrlServiceImpl implements UrlService {

	private final static String INPUT_FILE_NAME = "/Users/jlochman/Documents/Comfigo/products.txt";

	public List<String> getProductURLs() {
		List<String> list = null;
		try {
			list = Files.readAllLines(Paths.get(INPUT_FILE_NAME), Charset.forName("UTF-8"));
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				if (!UrlValidator.getInstance().isValid(iterator.next()))
					iterator.remove();
			}
		} catch (IOException e) {
			System.out.println("IOException while reading " + INPUT_FILE_NAME);
			e.printStackTrace();
		}
		return list;
	}

	public Document getHtmlPageFromURL(String url) {
		Document htmlPage;
		htmlPage = getHtmlWithTimeout(url, 10);
		if (htmlPage != null)
			return htmlPage;
		htmlPage = getHtmlWithTimeout(url, 30);
		if (htmlPage != null)
			return htmlPage;
		htmlPage = getHtmlWithTimeout(url, 60);
		if (htmlPage != null)
			return htmlPage;
		htmlPage = getHtmlWithTimeout(url, 120);
		return htmlPage;
	}

	private Document getHtmlWithTimeout(String url, int timeoutSec) {
		try {
			return Jsoup.connect(url).timeout(timeoutSec * 1000).get();
		} catch (IOException e) {
			System.out.println(url + " not loaded with timeout = " + timeoutSec + " sec");
			return null;
		}
	}

}
