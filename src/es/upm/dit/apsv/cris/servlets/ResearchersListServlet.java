package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import es.upm.dit.apsv.cris.dao.ResearcherDAO;
import es.upm.dit.apsv.cris.dao.ResearcherDAOImplementation;
import es.upm.dit.apsv.cris.model.Researcher;

/**
 * Servlet implementation class ResearchersListServlet
 */
@WebServlet("/ResearchersListServlet")
public class ResearchersListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResearcherDAO rdao = ResearcherDAOImplementation.getInstance();
		List<Researcher> researcherslist = rdao.readAll();
		request.getSession().setAttribute ("researcherslist", researcherslist);
		getServletContext().getRequestDispatcher("/ResearchersListView.jsp").forward(request, response);

	}
	


}
