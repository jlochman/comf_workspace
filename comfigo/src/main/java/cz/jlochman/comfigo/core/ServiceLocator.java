package cz.jlochman.comfigo.core;

import cz.jlochman.comfigo.core.services.ChairService;
import cz.jlochman.comfigo.core.services.FigureService;
import cz.jlochman.comfigo.core.services.ParameterService;
import cz.jlochman.comfigo.core.services.impl.ChairServiceImpl;
import cz.jlochman.comfigo.core.services.impl.FigureServiceImpl;
import cz.jlochman.comfigo.core.services.impl.ParameterServiceImpl;

public class ServiceLocator {

	private static ServiceLocator instance;

	private DAOSingleton daos;
	private ChairService chairService;
	private FigureService figureService;
	private ParameterService parameterService;

	private ServiceLocator() {
		daos = new DAOSingleton();
		chairService = new ChairServiceImpl();
		figureService = new FigureServiceImpl();
		parameterService = new ParameterServiceImpl();
	}

	public static ServiceLocator getInstance() {
		if (instance == null)
			instance = new ServiceLocator();

		return instance;
	}

	public DAOSingleton getDaos() {
		return daos;
	}

	public ChairService getChairService() {
		return chairService;
	}

	public FigureService getFigureService() {
		return figureService;
	}

	public ParameterService getParameterService() {
		return parameterService;
	}

}
