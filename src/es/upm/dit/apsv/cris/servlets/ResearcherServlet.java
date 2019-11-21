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

/**
 * Servlet implementation class ResearcherServlet
 */
@WebServlet("/ResearcherServlet")
public class ResearcherServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ResearcherDAO pdao = ResearcherDAOImplementation.getInstance();
		String researcherId = (String) request.getParameter("id");
		
		request.getSession().setAttribute ("researcherid", pdao.read(researcherId));
		
		getServletContext().getRequestDispatcher("/ResearcherView.jsp").forward(request, response);

	}
}
