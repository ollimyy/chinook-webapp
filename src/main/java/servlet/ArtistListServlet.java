package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ArtistDao;
import model.Artist;

@WebServlet("")
public class ArtistListServlet extends HttpServlet{
	
	private ArtistDao artDao = new ArtistDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = this.artDao.getAllArtists();
		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/artistlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String newArtistName = req.getParameter("add");
		// user used the add field
		if (newArtistName != null) {
			HttpSession ses = req.getSession();
			Artist newArtist = new Artist(newArtistName);
			String addMessage = "";
			
			if(artDao.addArtist(newArtist)) {
				addMessage = "Succesfully added artist \"" + newArtistName + "\""; 
			} else {
				addMessage = "Failed to add artist \"" + newArtistName + "\"";
			}
			
			ses.setAttribute("addmessage", addMessage);
			resp.sendRedirect("/");
		}
		
		String searchTerm = req.getParameter("search");
		// user used the search field
		if (searchTerm != null) {
			// avoid issues with user inputs containing special characters such as \ or &
			// https://stackoverflow.com/questions/10786042/java-url-encoding-of-query-string-parameters
			String url = "/search?term=" + URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
			resp.sendRedirect(url);
		}
	}
}
