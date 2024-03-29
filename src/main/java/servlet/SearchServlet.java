package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	private AlbumDao albDao = new AlbumDao();
	private ArtistDao artDao = new ArtistDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchTerm = req.getParameter("term");
		req.setAttribute("searchterm", searchTerm);
		
		//Artist search
		List<Artist> artistSearchResults = this.artDao.searchArtists(searchTerm);
		req.setAttribute("artists", artistSearchResults);
		
		//Album search
		List<Album> albumSearchResults = this.albDao.searchAlbums(searchTerm);
		req.setAttribute("albums", albumSearchResults);

		//Creates a HashMap to show artist name next to albums on the search page
		HashMap<String, String> albumArtists = new HashMap<>();
		for (Album album : albumSearchResults) {
			albumArtists.put(album.getTitle(), this.artDao.getName(album.getArtistId()));
		}
		req.setAttribute("albumartists", albumArtists);
		
		req.getRequestDispatcher("/WEB-INF/searchresults.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchTerm = req.getParameter("search");
		// avoid issues with user inputs containing special characters such as \ or &
		// https://stackoverflow.com/questions/10786042/java-url-encoding-of-query-string-parameters
		String url = "/search?term=" + URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
		resp.sendRedirect(url);
	}
}
