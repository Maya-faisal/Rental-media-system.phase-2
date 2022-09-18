package application;
import java.util.*;

public class Customer {

	private String name;
	private String address;
	private String plan;
	private String id;
	private String mobilenumber;
	private ArrayList<String> CustomerInterests = new ArrayList<>();
	private ArrayList<String> RentedMedia = new ArrayList<>();

	public Customer() 
	{

	}
	
	public Customer(String id)
	{
		this.id = id;
	}
	
	public Customer(String name, String address, String plan, String id , String mobilenumber)
	{
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.id = id;
		this.mobilenumber = mobilenumber;
	}

	public Customer(String name, String address, String plan, String id , String mobilenumber , ArrayList<String> customerInterests,ArrayList<String> rentedMedia)
	{

		this.name = name;
		this.address = address;
		this.plan = plan;
		this.id = id;
		this.mobilenumber = mobilenumber;
		CustomerInterests = customerInterests;
		RentedMedia = rentedMedia;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPlan()
	{
		return plan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setPlan(String plan) 
	{
		this.plan = plan;
	}

	public ArrayList<String> getCustomerInterests() 
	{
		return CustomerInterests;
	}

	public void setCustomerInterests(ArrayList<String> customerInterests)
	{
		CustomerInterests = customerInterests;
	}

	public ArrayList<String> getRentedMedia() 
	{
		return RentedMedia;
	}

	public void setRentedMedia(ArrayList<String> rentedMedia)
	{
		RentedMedia = rentedMedia;
	}
	
	public String toString()
	{
		
		return id+"-"+name+"-"+address+"-"+mobilenumber+"-"+plan+"\n";
		
	}

}
