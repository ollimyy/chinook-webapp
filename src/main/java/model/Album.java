package model;

public class Album {

	private long albumId;
	private String title;
	private long artistId;
	
	public Album(long albumId, String title, long artistId) {
		this.albumId = albumId;
		this.title = title;
		this.artistId = artistId;
	}
	
	public long getAlbumId() {
		return albumId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public long getArtistId() {
		return artistId;
	}
}
