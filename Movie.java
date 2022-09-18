package application;

public class Movie extends Media implements Comparable<Movie> {

	private String rating;

	public Movie() 
	{

	}

	public Movie(String title, String code ,int copiesAvailable, String rating)
	{
		super(title, code , copiesAvailable);
		this.rating = rating;

	}
	
	public String getRating() 
	{
		return rating;
	}

	public void setRating(String rating) 
	{
		this.rating = rating;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString()
	{
		return super.toString() + getRating() + "\n";
	}


	public String toString1()
	{
		return super.toString1() + "Rating: " + getRating() + "\n";
	}

}
