package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import es.upm.dit.apsv.cris.dao.ResearcherDAO;
import es.upm.dit.apsv.cris.dao.ResearcherDAOImplementation;
import es.upm.dit.apsv.cris.model.Researcher;


@WebServlet("/CreateResearcherServlet")
public class CreateResearcherServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		Researcher user = (Researcher) req.getSession().getAttribute("user");

		if ( user.getId() == "root") {
			String id = req.getParameter( "id" );
			String email = req.getParameter( "email" );
			String name = req.getParameter( "name" );
			String lastname = req.getParameter( "lastname" );
			String password = req.getParameter("password");
			
			Researcher researcher = new Researcher();
			researcher.setId(id);
			researcher.setEmail(email);
			researcher.setName(name);
			researcher.setLastname(lastname);
			researcher.setPassword(password);
			
			ResearcherDAO rdao = ResearcherDAOImplementation.getInstance();
			rdao.create(researcher);
			
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );

		} else {
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );

		}
			
		
		
		//resp.sendRedirect( req.getContextPath());

		
	}
	
}
