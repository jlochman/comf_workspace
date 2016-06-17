package cz.jlochman.comfigo.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cz.jlochman.comfigo.core.DAO.ProductDAO;
import cz.jlochman.comfigo.core.DAO.FigureDAO;
import cz.jlochman.comfigo.core.DAO.ParameterDAO;
import cz.jlochman.comfigo.core.DAO.database.ProductDatabaseDAO;
import cz.jlochman.comfigo.core.DAO.database.FigureDatabaseDAO;
import cz.jlochman.comfigo.core.DAO.database.ParameterDatabaseDAO;

public class DAOSingleton {

	private EntityManagerFactory emf;
	private FigureDAO figureDAO;
	private ParameterDAO parameterDAO;
	private ProductDAO productDAO;
	
	public DAOSingleton() {
		emf = Persistence.createEntityManagerFactory("comfigoDB");
		productDAO = new ProductDatabaseDAO();
		figureDAO = new FigureDatabaseDAO();
		parameterDAO = new ParameterDatabaseDAO();
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public FigureDAO getFigureDAO() {
		return figureDAO;
	}

	public ParameterDAO getParameterDAO() {
		return parameterDAO;
	}
	
}
