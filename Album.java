package application;
import java.util.*;

public class Album extends Media implements Comparable<Album> {

	private ArrayList<String> Songs;
	private String artist;
	
	public Album() 
	{
		
	}

	public Album(String title, String code ,int copiesAvailable, String artist, ArrayList<String> Songs) 
	{
		super(title, code ,copiesAvailable);
		this.artist = artist;
		this.Songs = Songs;

	}
	
	public String getArtist() 
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public ArrayList<String> getSongs()
	{
		return Songs;
	}

	public void setSongs(ArrayList<String> songs)
	{
		this.Songs = songs;
	}

	@Override
	public int compareTo(Album o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString()
	{
		return super.toString() + getArtist() + "-" + getSongs() + "\n" ;
	}

	public String toString1()
	{
		return super.toString1() + "Artist: " + getArtist() + "\n" + "songs: " + getSongs() + "\n" ;
	}
}

