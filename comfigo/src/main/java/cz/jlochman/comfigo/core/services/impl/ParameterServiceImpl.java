package cz.jlochman.comfigo.core.services.impl;

import java.util.List;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ParameterDAO;
import cz.jlochman.comfigo.core.entityDomain.Parameter;
import cz.jlochman.comfigo.core.services.ParameterService;

public class ParameterServiceImpl implements ParameterService {

	private ParameterDAO paramDAO = ServiceLocator.getInstance().getDaos().getParameterDAO();

	public List<Parameter> getAllParameters() {
		return paramDAO.getAllParameters();
	}

}
