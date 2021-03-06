package cz.jlochman.comfigo.core.DAO.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ParameterDAO;
import cz.jlochman.comfigo.core.entityDomain.Parameter;

public class ParameterDatabaseDAO implements ParameterDAO {
	
	@SuppressWarnings("unchecked")
	public List<Parameter> getAllParameters() {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		List<Parameter> list = new ArrayList<Parameter>();
		try {
			list = em.createQuery("FROM Parameter par ORDER BY par.id ").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
}
