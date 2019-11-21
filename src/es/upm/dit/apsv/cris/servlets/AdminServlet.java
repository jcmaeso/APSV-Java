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

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResearcherDAO rdao = ResearcherDAOImplementation.getInstance();
		req.getSession().setAttribute( "researcherslist", rdao.readAll() );
		PublicationDAO pdao = PublicationDAOImplementation.getInstance();
		req.getSession().setAttribute( "publicationslist", pdao.readAll() );
		
		if (req.getSession() != null) {
			getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
		} else {
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );

		}

	}


}
