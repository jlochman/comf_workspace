package cz.jlochman.comfigo.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cz.jlochman.comfigo.core.DAO.ChairDAO;
import cz.jlochman.comfigo.core.DAO.FigureDAO;
import cz.jlochman.comfigo.core.DAO.ParameterDAO;
import cz.jlochman.comfigo.core.DAO.database.ChairDatabaseDAO;
import cz.jlochman.comfigo.core.DAO.database.FigureDatabaseDAO;
import cz.jlochman.comfigo.core.DAO.database.ParameterDatabaseDAO;

public class DAOSingleton {

	private EntityManagerFactory emf;
	private ChairDAO chairDAO;
	private FigureDAO figureDAO;
	private ParameterDAO parameterDAO;
	
	public DAOSingleton() {
		emf = Persistence.createEntityManagerFactory("comfigoDB");
		chairDAO = new ChairDatabaseDAO();
		figureDAO = new FigureDatabaseDAO();
		parameterDAO = new ParameterDatabaseDAO();
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public ChairDAO getChairDAO() {
		return chairDAO;
	}

	public FigureDAO getFigureDAO() {
		return figureDAO;
	}

	public ParameterDAO getParameterDAO() {
		return parameterDAO;
	}
	
}
