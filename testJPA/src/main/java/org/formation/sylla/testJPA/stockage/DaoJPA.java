package org.formation.sylla.testJPA.stockage;

import java.util.List;

import org.formation.sylla.testJPA.service.PersonnePOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoJPA {
	private EntityManager em;

	public DaoJPA() {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("testJPA");
		em = emf.createEntityManager();

	}
	
	@SuppressWarnings("unchecked")
	public List<PersonnePOJO> lireTous(){
	return em.createQuery("SELECT p FROM PersonnePOJO p").getResultList();
	}

	public PersonnePOJO lire(int cle) {
		return (PersonnePOJO) em.createQuery("SELECT p FROM PersonnePOJO p WHERE p.id= " + cle).getSingleResult();
	}

}
