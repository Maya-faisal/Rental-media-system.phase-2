package application;

public abstract class Media {

	protected String title;
	protected String code;
	protected int copiesAvailable;

	public Media()
	{

	}

	public Media(String title, String code ,int copiesAvailable)
	{

		this.title = title;
		this.code = code;
		this.copiesAvailable = copiesAvailable;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCopiesAvailable()
	{
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable)
	{
		this.copiesAvailable = copiesAvailable;
	}
	
	public String toString()
	{
		return getCode() +"-"+ getTitle() +"-"+ getCopiesAvailable() + "-";
		
	}
	
	public String toString1()
	{
		return "Code: " + getCode() + "\n"  + "Title: " + getTitle() + "\n" + "Copies Available: " + getCopiesAvailable() + "\n";
	}
	
	// public abstract boolean equals(Object x);

}
