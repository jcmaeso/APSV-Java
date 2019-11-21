package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.cris.dao.PublicationDAO;
import es.upm.dit.apsv.cris.dao.PublicationDAOImplementation;
import es.upm.dit.apsv.cris.dao.ResearcherDAO;
import es.upm.dit.apsv.cris.dao.ResearcherDAOImplementation;
import es.upm.dit.apsv.cris.model.Publication;
import es.upm.dit.apsv.cris.model.Researcher;

/**
 * Servlet implementation class CreatePublicationServlet
 */
@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter( "id" );
		Researcher user = (Researcher) req.getSession().getAttribute("user");

		
		String title = req.getParameter( "title" );
		String publicationName = req.getParameter( "publicationName" );
		String publicationDate = req.getParameter( "publicationDate" );
		String authors = req.getParameter("authors");
		
		Publication publication = new Publication(id,title,publicationName,publicationDate,authors);
		
		PublicationDAO pdao = PublicationDAOImplementation.getInstance();
		pdao.create(new Publication(id,title,publicationName,publicationDate,authors));
		
		ResearcherDAO rdao = ResearcherDAOImplementation.getInstance();
	    Researcher researcher = rdao.read(user.getId());
	    researcher.getPublications().add(publication);
	    rdao.update(researcher);    
	
	
		resp.sendRedirect(req.getContextPath() + "/ResearcherServlet" + "?id=" + user.getId());
		
	}
}
