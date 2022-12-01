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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		boolean success = false;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Artist (name) VALUES (?)");
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
}
