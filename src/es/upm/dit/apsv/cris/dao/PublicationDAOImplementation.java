package es.upm.dit.apsv.cris.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.cris.model.Publication;
import es.upm.dit.apsv.cris.model.Researcher;

public class PublicationDAOImplementation implements PublicationDAO {
	private static PublicationDAOImplementation instance = null;
	private PublicationDAOImplementation() {}
	public static PublicationDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new PublicationDAOImplementation();
	    }
	    return instance;
	}
	@Override
	public Publication create(Publication publication) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(publication);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return publication;
	}
	@Override
	public Publication read(String publicationId) {
		Session session = SessionFactoryService.get().openSession();
		Publication publication = null;
		try {
			session.beginTransaction();
			publication = (Publication) session.createQuery("select p from Publication p where p.publicationId = :publicationId")
					.setParameter("publicationId", publicationId)
					.getSingleResult();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return publication;
	}
	@Override
	public Publication update(Publication publication) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(publication);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return publication;
	}
	@Override
	public Publication delete(Publication publication) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(publication);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return publication;
	}
	@Override
	public List<Publication> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Publication> publications = null;
		try {
			session.beginTransaction();
			publications = session.createQuery("from Publication").list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return publications;
	}


}
