package cz.jlochman.comfigo.core.DAO.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ImageDAO;
import cz.jlochman.comfigo.core.entityDomain.Image;

public class ImageDatabaseDAO implements ImageDAO {

	@SuppressWarnings("unchecked")
	public List<Image> getAllImages() {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		List<Image> list = new ArrayList<Image>();
		try {
			list = em.createQuery("FROM Image img ORDER BY img.id ").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

}
