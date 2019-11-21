package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getSession() == null) {
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
		}
		List<Researcher> researchers = ResearcherDAOImplementation.getInstance().readAll();
		List<Publication> publications = PublicationDAOImplementation.getInstance().readAll();
		req.getSession().setAttribute( "researcherslist", researchers );
		req.getSession().setAttribute( "publicationslist", publications );
		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );

	}


}
