package application;


public class Game extends Media implements Comparable<Game> {

	private double weight;

	public Game() 
	{

	}

	public Game(String title, String code ,int copiesAvailable, double weight)
	{
		super(title, code ,copiesAvailable);
		this.weight = weight;

	}
	public Game(String title)
	{
		this.title = title;
	}
	
	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	@Override
	public int compareTo(Game o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String toString()
	{
		return  super.toString() + getWeight() + "\n";
	}
	
	public String toString1()
	{
		return super.toString1() + "weight: " +  getWeight() + "\n";
	}
}

