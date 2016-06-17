package cz.jlochman.comfigo.core;

import cz.jlochman.comfigo.core.services.FileService;
import cz.jlochman.comfigo.core.services.ImageService;
import cz.jlochman.comfigo.core.services.ParameterService;
import cz.jlochman.comfigo.core.services.ProductService;
import cz.jlochman.comfigo.core.services.UrlService;
import cz.jlochman.comfigo.core.services.impl.FileServiceImpl;
import cz.jlochman.comfigo.core.services.impl.ImageServiceImpl;
import cz.jlochman.comfigo.core.services.impl.ParameterServiceImpl;
import cz.jlochman.comfigo.core.services.impl.ProductServiceImpl;
import cz.jlochman.comfigo.core.services.impl.UrlServiceImpl;

public class ServiceLocator {

	private static ServiceLocator instance;

	private DAOSingleton daos;
	private ImageService imageService;
	private ParameterService parameterService;
	private ProductService productService;
	private UrlService urlService;
	private FileService fileService;

	private ServiceLocator() {
		daos = new DAOSingleton();
		productService = new ProductServiceImpl();
		imageService = new ImageServiceImpl();
		parameterService = new ParameterServiceImpl();
		urlService = new UrlServiceImpl();
		fileService = new FileServiceImpl();
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

	public ImageService getImageService() {
		return imageService;
	}

	public ParameterService getParameterService() {
		return parameterService;
	}

	public UrlService getUrlService() {
		return urlService;
	}

	public FileService getFileService() {
		return fileService;
	}

}
