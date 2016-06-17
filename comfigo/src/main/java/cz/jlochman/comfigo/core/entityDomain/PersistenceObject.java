package cz.jlochman.comfigo.core.entityDomain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import cz.jlochman.comfigo.core.ServiceLocator;

@MappedSuperclass
public class PersistenceObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id = null;

	@Column(name = "CREATED")
	private Date created;

	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PersistenceObject)) {
			return false;
		}
		final PersistenceObject other = (PersistenceObject) obj;
		if (this.id != null && other.id != null) {
			if (this.id != other.id) {
				return false;
			}
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void save() {
		if (id == null || created == null)
			created = new Date();
		lastUpdated = new Date();

		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		try {
			em.getTransaction().begin();
			if (id == null) {
				em.persist(this);
			} else {
				em.merge(this);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void delete() {
		EntityManager em = ServiceLocator.getInstance().getDaos().getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(this) ? this : em.merge(this));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
