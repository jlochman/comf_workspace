package cz.jlochman.comfigo.core;

import cz.jlochman.comfigo.core.services.ProductService;
import cz.jlochman.comfigo.core.services.FigureService;
import cz.jlochman.comfigo.core.services.ParameterService;
import cz.jlochman.comfigo.core.services.UrlService;
import cz.jlochman.comfigo.core.services.impl.ProductServiceImpl;
import cz.jlochman.comfigo.core.services.impl.FigureServiceImpl;
import cz.jlochman.comfigo.core.services.impl.ParameterServiceImpl;
import cz.jlochman.comfigo.core.services.impl.UrlServiceImpl;

public class ServiceLocator {

	private static ServiceLocator instance;

	private DAOSingleton daos;
	private FigureService figureService;
	private ParameterService parameterService;
	private ProductService productService;
	private UrlService urlService;

	private ServiceLocator() {
		daos = new DAOSingleton();
		productService = new ProductServiceImpl();
		figureService = new FigureServiceImpl();
		parameterService = new ParameterServiceImpl();
		urlService = new UrlServiceImpl();
	}

	public static ServiceLocator getInstance() {
		if (instance == null)
			instance = new ServiceLocator();

		return instance;
	}

	public DAOSingleton getDaos() {
		return daos;
	}

	public ProductService getProductService() {
		return productService;
	}

	public FigureService getFigureService() {
		return figureService;
	}

	public ParameterService getParameterService() {
		return parameterService;
	}

	public UrlService getUrlService() {
		return urlService;
	}

}
