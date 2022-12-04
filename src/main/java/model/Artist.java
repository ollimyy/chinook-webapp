package model;

public class Artist {

		private long artistId;
		private String name;
		
		public Artist(long artistId, String name) {
			this.artistId = artistId;
			this.name = name;
		}
		
		public Artist(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public long getArtistId() {
			return artistId;
		}
}