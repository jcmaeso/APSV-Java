package es.upm.dit.apsv.cris.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.cris.model.Researcher;

public class ResearcherDAOImplementation implements ResearcherDAO {
	private static ResearcherDAOImplementation instance = null;
	private ResearcherDAOImplementation() {}
	public static ResearcherDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new ResearcherDAOImplementation();
	    }
	    return instance;
	}
	@Override
	public Researcher create(Researcher researcher) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(researcher);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researcher;
	}
	@Override
	public Researcher read(String researcherId) {
		Session session = SessionFactoryService.get().openSession();
		Researcher researcher = null;
		try {
			session.beginTransaction();
			researcher = (Researcher) session.createQuery("select r from Researcher r where r.id = :researcherId")
					.setParameter("researcherId", researcherId)
					.getSingleResult();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researcher;
	}
	@Override
	public Researcher update(Researcher researcher) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(researcher);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researcher;
	}
	@Override
	public Researcher delete(Researcher researcher) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(researcher);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researcher;
	}
	@Override
	public List<Researcher> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Researcher> researchers = null;
		try {
			session.beginTransaction();
			researchers = session.createQuery("from Researcher").list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researchers;
	}
	@Override
	public Researcher readAsUser(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Researcher researcher = null;
		try {
			session.beginTransaction();
			researcher = (Researcher) session.createQuery("select r from Researcher r where r.email = :email and r.password = :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.uniqueResult();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return researcher;
	}
}
