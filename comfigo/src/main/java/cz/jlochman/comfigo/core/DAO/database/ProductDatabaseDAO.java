package cz.jlochman.comfigo.core.DAO.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ProductDAO;
import cz.jlochman.comfigo.core.entityDomain.Product;

public class ProductDatabaseDAO implements ProductDAO {

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		List<Product> list = new ArrayList<Product>();
		try {
			list = em.createQuery("FROM Product prod ORDER BY prod.id ").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Date> getAllDownDates() {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		List<Date> list = new ArrayList<Date>();
		try {
			list = em.createQuery("SELECT DISTINCT prod.downloadDate FROM Product prod ORDER BY prod.downloadDate ")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsForDownDate(Date downDate) {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		List<Product> list = new ArrayList<Product>();
		try {
			Query query = em.createQuery("FROM Product prod WHERE prod.downloadDate = :downDate ORDER BY prod.id ");
			query.setParameter("downDate", downDate);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

}
