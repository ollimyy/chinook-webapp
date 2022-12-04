package servlet;

import java.io.IOException;
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
}
