package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

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
}
