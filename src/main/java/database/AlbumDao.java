package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class AlbumDao {

	private Database db = new Database();
	
	public List<Album> getAlbumsBy(final long artistId){
		
		List<Album> albumList = new ArrayList<>();
		String selectAll = "SELECT * FROM Album WHERE ArtistId = ? ORDER BY Title ASC";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setString(1, Long.toString(artistId));
			results = statement.executeQuery();
			
			while(results.next()) {
				albumList.add(new Album(results.getLong("AlbumId"), results.getString("Title"), results.getLong("ArtistId")));
			}
		
		} catch (SQLException sqle){
			sqle.printStackTrace();
			
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return albumList;
	}
	
	public List<Album> searchAlbums(final String searchTerm){
		String selectLike = "SELECT AlbumId, ArtistId, Title FROM Album WHERE Title LIKE ? ORDER BY Title ASC";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> searchResults = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectLike);
			statement.setString(1, "%" + searchTerm + "%");
			results = statement.executeQuery();
			
			while (results.next()) {
				long albumId = results.getLong("AlbumId");
				String title = results.getString("Title");
				long artistId = results.getLong("ArtistId");
				
				searchResults.add(new Album(albumId, title, artistId));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return searchResults;
	}
}
