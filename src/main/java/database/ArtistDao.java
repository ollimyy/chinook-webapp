package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class ArtistDao {
	
	private Database db = new Database();
	
	public String getName(long id) {
		String selectWhereId = "SELECT Name FROM Artist WHERE ArtistId = ?";
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String artistName = "";
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectWhereId);
			statement.setString(1, Long.toString(id));
			result = statement.executeQuery();
			
			artistName = result.getString("Name");
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		} finally {
		db.closeAll(connection, statement, result);
		}
		
		return artistName;
	}
	
	public List<Artist> getAllArtists(){
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> allArtists = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				
				allArtists.add(new Artist(id, name));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return allArtists;
	}
	
	public boolean addArtist(Artist newArtist) {
		String insert = "INSERT INTO Artist (Name) VALUES (?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		boolean success = false;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(insert);
			statement.setString(1, newArtist.getName());
			
			int lines = statement.executeUpdate();
			if (lines > 0) {
				success = true;
			}
				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		} finally {
		db.closeAll(connection, statement, result);
		}
		
		return success;
	}
	
	public List<Artist> searchArtists(final String searchTerm){
		String selectLike = "SELECT ArtistId, Name FROM Artist WHERE Name LIKE ? ORDER BY Name ASC";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> searchResults = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectLike);
			statement.setString(1, "%" + searchTerm + "%");
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				
				searchResults.add(new Artist(id, name));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return searchResults;
	}
}
