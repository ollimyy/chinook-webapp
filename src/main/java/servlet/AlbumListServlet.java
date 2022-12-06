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

import database.AlbumDao;
import database.ArtistDao;
import model.Album;

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet{

	private AlbumDao albDao = new AlbumDao();
	private ArtistDao artDao = new ArtistDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long artistId = Long.parseLong(req.getParameter("ArtistId"));
		String artistName = artDao.getName(artistId);
		req.setAttribute("artist", artistName);
		
		List<Album> albums = albDao.getAlbumsBy(artistId);
		req.setAttribute("albums", albums);
		req.getRequestDispatcher("/WEB-INF/albumlist.jsp").forward(req, resp);
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
